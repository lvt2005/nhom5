package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.response.DoctorDetailResponse;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.ReviewDetailResponse;
import com.doctor_appointment.exception.ResourceNotFoundException;
import com.doctor_appointment.model.*;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.repository.ReviewRepository;
import com.doctor_appointment.service.ReviewService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;
  private final DoctorRepository doctorRepository;

  @Override
  public Boolean deleteReview(int reviewId) {
    Review review = reviewRepository.findById(reviewId)
            .orElseThrow(()-> new ResourceNotFoundException("Review not found"));
    reviewRepository.delete(review);
    return true;
  }

  @Override
  public PageResponse<?> getAllReviewsWithSortBy(int pageNo, int pageSize, String sortBy) {
    if (pageNo > 0) {
      pageNo = pageNo - 1;
    }

    List<Sort.Order> sorts = new ArrayList<>();

    //If sortBy exits
    // Parse sortBy: "fullName:asc"
    if (StringUtils.hasLength(sortBy)) {
      Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");
      Matcher matcher = pattern.matcher(sortBy);
      if (matcher.find()) {
        if (matcher.group(3).equalsIgnoreCase("asc")) {
          sorts.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
        } else {
          sorts.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
        }
      }
    }

    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sorts));

    Page<Review> reviews = reviewRepository.findAll(pageable);

    List<ReviewDetailResponse> response = reviews.stream().map(review -> {

      Integer doctorId = review.getDoctor().getId();
      Long orderId = review.getTreatmentOrder().getId();

      return ReviewDetailResponse.builder()
              .id(review.getId())
              .comment(review.getComment())
              .rating(review.getRating())
              .doctorId(doctorId)
              .treatmentOrderId(orderId)
              .build();
    }).toList();


    return PageResponse.<ReviewDetailResponse>builder()
            .pageNo(pageNo)
            .pageSize(pageSize)
            .totalPage(reviews.getTotalPages())
            .items(response)
            .build();
  }
}

package com.doctor_appointment.service;

import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.model.Review;

public interface ReviewService{
  Boolean deleteReview(int reviewId);
  PageResponse<?> getAllReviewsWithSortBy(int pageNo, int pageSize, String sortBy);
}

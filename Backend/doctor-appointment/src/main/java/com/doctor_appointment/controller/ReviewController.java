package com.doctor_appointment.controller;

import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@Slf4j(topic = "REVIEW-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Review Management", description = "APIs for managing review")
public class ReviewController {
  private final ReviewService reviewService;

  @Operation(summary = "Get all review", description = "Get all review from database")
  @GetMapping("/list")
  public ResponseData<?> getAllReviews(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                       @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize,
                                       @RequestParam(required = false) String sortBy){
    log.info("Get all review");

    try {
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete a doctor", reviewService.getAllReviewsWithSortBy(pageNo, pageSize, sortBy));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }

  }

  @Operation(summary = "Delete a review", description = "Remove a review from database")
  @DeleteMapping("/delete/{reviewId}")
  public ResponseData<?> delete(@PathVariable @Min(1) int reviewId){
    log.info("Delete a review");

    try {
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete a doctor", reviewService.deleteReview(reviewId));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }

  }



}

package com.doctor_appointment.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ReviewDetailResponse implements Serializable {
  private Long id;
  private int rating;
  private String comment;
  private Long treatmentOrderId;
  private Integer doctorId;
}

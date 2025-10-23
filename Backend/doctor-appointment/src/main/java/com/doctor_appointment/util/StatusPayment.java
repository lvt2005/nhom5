package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusPayment {
  @JsonProperty("success")
  SUCCESS,
  @JsonProperty("failed")
  FAILED,
  @JsonProperty("refunded")
  REFUNDED,
  @JsonProperty("pending")
  PENDING
}

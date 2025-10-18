package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserStatus {
  @JsonProperty("active")
  ACTIVE,
  @JsonProperty("inactive")
  INACTIVE,
  @JsonProperty("none")
  NONE;
}

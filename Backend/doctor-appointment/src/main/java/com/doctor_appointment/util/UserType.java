package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserType {
  @JsonProperty("owner")
  OWNER,
  @JsonProperty("admin")
  ADMIN,
  @JsonProperty("user")
  USER;
}

package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Sent {
  @JsonProperty("email")
  EMAIL,
  @JsonProperty("system")
  SYSTEM,
  @JsonProperty("both")
  BOTH
}

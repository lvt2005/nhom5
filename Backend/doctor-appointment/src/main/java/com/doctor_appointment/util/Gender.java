package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Gender {
  @JsonProperty("male")
  MALE,
  @JsonProperty("female")
  FEMALE,
  @JsonProperty("other")
  OTHER

}

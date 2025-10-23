package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Day {
  @JsonProperty("mon")
  MON,
  @JsonProperty("tue")
  TUE,
  @JsonProperty("wed")
  WED,
  @JsonProperty("thu")
  THU,
  @JsonProperty("fri")
  FRI,
  @JsonProperty("sat")
  SAT,
  @JsonProperty("sun")
  SUN
}

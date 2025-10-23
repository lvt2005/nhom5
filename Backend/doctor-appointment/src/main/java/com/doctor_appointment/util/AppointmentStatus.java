package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AppointmentStatus {
  @JsonProperty("pedding")
  PENDING,
  @JsonProperty("confirmed")
  CONFIRMED,
  @JsonProperty("completed")
  COMPLETED,
  @JsonProperty("cancelled")
  CANCELLED
}

package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum NotificationType {
  @JsonProperty("account")
  ACCOUNT,
  @JsonProperty("appointment")
  APPOINTMENT,
  @JsonProperty("reminder")
  REMINDER,
  @JsonProperty("system")
  SYSTEM,
  @JsonProperty("payment")
  PAYMENT
}

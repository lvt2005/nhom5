package com.doctor_appointment.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MethodPayment {
  @JsonProperty("cash")
  CASH,
  @JsonProperty("bank")
  BANK,
  @JsonProperty("momo")
  MOMO,
  @JsonProperty("zalopay")
  ZALOPAY
}

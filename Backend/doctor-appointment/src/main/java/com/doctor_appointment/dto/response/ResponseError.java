package com.doctor_appointment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError extends ResponseData{
  public ResponseError(int status, String message, Object data) {
    super(status, message, data);
  }
}

package com.doctor_appointment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseData<T> {
  private int status;
  private String message;
  private T data;


  //PUT, PATCH, DELETE
  public ResponseData(int status, String message) {
    this.status = status;
    this.message = message;
  }
}

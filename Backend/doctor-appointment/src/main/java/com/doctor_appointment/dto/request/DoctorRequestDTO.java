package com.doctor_appointment.dto.request;

import lombok.*;

import java.io.Serializable;



@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequestDTO extends UserRequestDTO implements Serializable {
  private int experience;
  private String doctorDesc;
  private  Integer specialId;
}

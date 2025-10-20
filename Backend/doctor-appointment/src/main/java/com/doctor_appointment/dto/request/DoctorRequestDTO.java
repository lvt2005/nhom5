package com.doctor_appointment.dto.request;

import lombok.*;

import java.io.Serializable;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO extends UserRequestDTO implements Serializable {

  private int experience;
  private String specialName;
  private String specialDesc;
}

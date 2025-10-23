package com.doctor_appointment.dto.request;

import com.doctor_appointment.util.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClinicRequestDTO implements Serializable {
  private String name;
  private String address;
  private String hotline;
  private String email;
  private Date openingHours;
  private String description;
  private Status status;
  private Set<Integer> doctorId;
}

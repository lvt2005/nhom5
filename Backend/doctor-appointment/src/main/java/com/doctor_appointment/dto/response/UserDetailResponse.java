package com.doctor_appointment.dto.response;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Setter
@Getter
public class UserDetailResponse implements Serializable {
  private Long id;
  private String fullname;
  private String email;
  private String phone;
  private String address;
  private Date dateOfBirth;
  private Gender gender;
  private Status status;
}

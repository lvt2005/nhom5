package com.doctor_appointment.dto.request;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.UserStatus;
import com.doctor_appointment.util.UserType;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class UserRequestDTO implements Serializable {
  private String email;

  private Gender gender;

  private String fullname;

  private String phone;

  private Date dateOfBirth;

  private String avatarUrl;

  private String address;

  private UserStatus status;

  private UserType type;
}

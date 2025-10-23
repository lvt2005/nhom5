package com.doctor_appointment.dto.response;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.Status;
import com.doctor_appointment.util.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class DoctorDetailResponse implements Serializable {
  private Integer doctorId;
  private String fullName;
  private Gender gender;
  private Date dateOfBirth;
  private String address;
  private String phone;
  private String email;
  private Status status;
  private UserType type;

  private Integer experienceYear;
  private Float ratingAvg;

  private String specialName;
  private String specialDesc;


}

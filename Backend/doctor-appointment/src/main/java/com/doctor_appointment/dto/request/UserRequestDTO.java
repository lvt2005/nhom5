package com.doctor_appointment.dto.request;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.Status;
import com.doctor_appointment.util.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable {

  private String email;

  private String password;

  private Gender gender;

  private String fullname;

  private String phone;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE )
  @JsonFormat(pattern = "MM/dd/yyyy")
  private Date dateOfBirth;

  private String avatarUrl;

  private String address;

  private Status status;

  private UserType type;

  private Integer specialId;

  private Set<Integer> roleId;

}

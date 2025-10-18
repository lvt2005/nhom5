package com.doctor_appointment.model;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.UserStatus;
import com.doctor_appointment.util.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends AbstractEntity<Long>{
  @Column(name = "full_name")
  private String fullname;

  @Column(name = "dob")
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "phone")
  private String phone;

  @Column(name = "address")
  private String address;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserStatus status;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private UserType type;

  @Column(name = "avatar_url")
  private String avatarUrl;
}

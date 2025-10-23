package com.doctor_appointment.model;

import com.doctor_appointment.util.Gender;
import com.doctor_appointment.util.Status;
import com.doctor_appointment.util.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_user")
@Entity(name = "User")
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
  private Status status;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private UserType type;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<UserHasRole> userHasRoles = new HashSet<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<UserHasGroup> groups = new HashSet<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<TreatmentOrder> orders = new ArrayList<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Notification> notifications = new ArrayList<>();

  @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Doctor doctor;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<VerificationToken> verificationTokens = new ArrayList<>();
}

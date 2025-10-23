package com.doctor_appointment.model;

import com.doctor_appointment.util.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_clinic")
@Entity(name = "Clinic")
public class Clinic extends AbstractEntity<Integer>{

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "hotline")
  private String hotline;

  @Column(name = "email")
  private String email;

  @Column(name = "opening_hours")
  private Date openingHours;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  private Status status;

  @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true )
  private List<Doctor> doctors = new ArrayList<>();


}

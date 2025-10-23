package com.doctor_appointment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_specialization")
@Entity(name = "Specialization")
public class Specialization extends AbstractEntity<Integer> {

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Builder.Default
  @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Doctor> doctors = new ArrayList<>();

  public void addDoctor(Doctor doctor) {
    doctors.add(doctor);
    doctor.setSpecialization(this);
  }
}

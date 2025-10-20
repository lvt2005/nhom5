package com.doctor_appointment.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_doctor")
@Entity(name = "Doctor")
public class Doctor extends AbstractEntity<Integer> {

  @Column(name = "experience")
  private int experience;

  @Column(name = "description")
  private String description;

  @Column(name = "rating_avg")
  private float ratingAvg;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specialization_id", referencedColumnName = "id")
  private Specialization specialization;

}

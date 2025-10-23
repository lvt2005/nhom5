package com.doctor_appointment.model;

import com.doctor_appointment.util.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
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

  @Column(name = "doctor_status")
  @Enumerated(EnumType.STRING)
  private Status doctorStatus;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @OneToOne(mappedBy = "doctor",  cascade = CascadeType.ALL, orphanRemoval = true)
  private Review review;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specialization_id", referencedColumnName = "id")
  private Specialization specialization;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "clinic_id", referencedColumnName = "id")
  private Clinic clinic;

  @OneToMany(mappedBy = "doctor",  cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WorkSchedule> workSchedules = new ArrayList<>();

  @OneToMany(mappedBy = "doctor",  cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TreatmentOrder> orders = new ArrayList<>();


}

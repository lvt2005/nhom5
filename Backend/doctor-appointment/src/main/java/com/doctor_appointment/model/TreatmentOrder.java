package com.doctor_appointment.model;

import com.doctor_appointment.util.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_treatment_order")
@Entity(name = "TreatmentOrder")
public class TreatmentOrder extends AbstractEntity<Long>{

  @Column(name ="appointment_date")
  private LocalDateTime appointmentDate;

  @Column(name ="status")
  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;

  @Column(name ="note")
  private String note;

  @OneToOne(mappedBy = "treatmentOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private TreatmentProgress treatmentProgress;

  @OneToOne(mappedBy = "treatmentOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Payment payment;

  @OneToOne(mappedBy = "treatmentOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Review review;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="doctor_id", referencedColumnName = "id")
  private Doctor doctor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="service_id", referencedColumnName = "id")
  private TreatmentServiceEntity service;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="user_id", referencedColumnName = "id")
  private UserEntity user;
}

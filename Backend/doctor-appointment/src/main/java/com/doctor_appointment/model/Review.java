package com.doctor_appointment.model;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_review")
@Entity(name = "Review")
public class Review extends AbstractEntity<Long>{

  @Column(name ="rating")
  private int rating;

  @Column(name ="comment")
  private String comment;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private TreatmentOrder treatmentOrder;

  @OneToOne
  @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  private Doctor doctor;

}

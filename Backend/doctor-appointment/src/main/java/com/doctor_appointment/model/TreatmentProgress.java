package com.doctor_appointment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_treatment_progress")
@Entity(name = "TreatmentProgress")
public class TreatmentProgress extends AbstractEntity<Long>{

  @Column(name ="date")
  private Date date;

  @Column(name ="diagnosis")
  private String diagnosis;

  @Column(name ="prescription")
  private String prescription;

  @Column(name ="result")
  private String result;

  @Column(name ="doctor_note")
  private String doctorNote;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private TreatmentOrder treatmentOrder;

}

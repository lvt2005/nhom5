package com.doctor_appointment.model;

import com.doctor_appointment.util.MethodPayment;
import com.doctor_appointment.util.StatusPayment;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_payment")
@Entity(name = "Payment")
public class Payment extends AbstractEntity<Long>{

  @Column(name = "amount")
  private float amount;

  @Column(name = "method")
  @Enumerated(EnumType.STRING)
  private MethodPayment method;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusPayment status;

  @Column(name = "transaction_time")
  private Date transactionTime;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private TreatmentOrder treatmentOrder;
}

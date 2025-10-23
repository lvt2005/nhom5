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
@Table(name = "tbl_treatment_service")
@Entity(name = "TreatmentService")
public class TreatmentServiceEntity extends AbstractEntity<Integer> {

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private String price;

  @Column(name = "duration_minutes")
  private int durationMinutes;

  @Column(name = "is_active")
  private Boolean isActive = true;

  @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TreatmentOrder> treatmentOrders = new ArrayList<>();
}

package com.doctor_appointment.model;

import com.doctor_appointment.util.Day;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_work_schedule")
@Entity(name = "WorkSchedule")
public class WorkSchedule extends AbstractEntity<Integer> {

  private Day dayOfWeek;
  private Time startTime;
  private Time endTime;
  private boolean isAvailable;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  private Doctor doctor;
}

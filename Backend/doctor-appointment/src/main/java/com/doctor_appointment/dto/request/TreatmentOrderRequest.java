package com.doctor_appointment.dto.request;

import com.doctor_appointment.util.AppointmentStatus;
import com.doctor_appointment.util.MethodPayment;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class TreatmentOrderRequest implements Serializable {

  private Integer serviceId;

  private LocalDateTime appointmentDate;

  @NotNull(message = "status must be not null")
  private AppointmentStatus appointmentStatus;

  private String note;

  private MethodPayment method;

  private Integer doctorId;

  private Long userId;



}

package com.doctor_appointment.dto.response;

import com.doctor_appointment.util.AppointmentStatus;
import com.doctor_appointment.util.StatusPayment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
public class TreatmentOrderDetailResponse implements Serializable {
  private Long id;
  private Date appointmentDate;
  private AppointmentStatus status;
  private String note;
  private String serviceName;
  private StatusPayment statusPayment;
  private Integer doctorId;
  private Long userID;
}

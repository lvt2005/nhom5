package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.TreatmentServiceDTO;

public interface TreatmentService {
  Boolean addService(TreatmentServiceDTO request);

  Boolean updateService(TreatmentServiceDTO request);

  Boolean deleteService(int id);
}

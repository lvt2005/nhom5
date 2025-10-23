package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.ClinicRequestDTO;

public interface ClinicService {
  Integer addClinic(ClinicRequestDTO request);
  Integer updateClinic(int id, ClinicRequestDTO request);
  Boolean deleteClinic(int id);
}

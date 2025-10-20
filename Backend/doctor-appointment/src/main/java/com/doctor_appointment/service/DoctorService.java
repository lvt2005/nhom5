package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.model.Doctor;
import org.springframework.stereotype.Service;

public interface DoctorService {
  Long addDoctor(DoctorRequestDTO request);
}

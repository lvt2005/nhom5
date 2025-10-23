package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.dto.response.PageResponse;
import jakarta.validation.constraints.Min;

public interface DoctorService {
  Integer updateDoctor(Integer doctorId, DoctorRequestDTO request);
  PageResponse<?> getAllDoctorsWithSortBy(int pageNo, int pageSize, String sortBy);

  Boolean deleteDoctor(@Min(1) int doctorId);
}


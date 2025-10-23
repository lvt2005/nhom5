package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.ClinicRequestDTO;
import com.doctor_appointment.model.Clinic;
import com.doctor_appointment.model.Doctor;
import com.doctor_appointment.repository.ClinicRepository;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.service.ClinicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {
  private final ClinicRepository clinicRepository;
  private final DoctorRepository doctorRepository;

  @Override
  public Integer addClinic(ClinicRequestDTO request) {

    Clinic clinic = Clinic.builder()
            .name(request.getName())
            .address(request.getAddress())
            .hotline(request.getHotline())
            .email(request.getEmail())
            .openingHours(request.getOpeningHours())
            .description(request.getDescription())
            .status(request.getStatus())
            .build();

    clinicRepository.save(clinic);


    return clinic.getId();
  }

  @Override
  public Integer updateClinic(int id, ClinicRequestDTO request) {
    Clinic clinic = clinicRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Clinic not found"));

    List<Doctor> doctors = new ArrayList<>();
    for(Integer doctorId : request.getDoctorId()){
      Doctor doctor = doctorRepository.findById(doctorId)
              .orElseThrow(()-> new RuntimeException("Clinic not found"));
      doctors.add(doctor);
    }

    clinic.setName(request.getName());
    clinic.setAddress(request.getAddress());
    clinic.setHotline(request.getHotline());
    clinic.setEmail(request.getEmail());
    clinic.setOpeningHours(request.getOpeningHours());
    clinic.setDescription(request.getDescription());
    clinic.setStatus(request.getStatus());
    clinic.setDoctors(doctors);

    return clinic.getId();
  }

  @Override
  public Boolean deleteClinic(int id) {
    Clinic clinic = clinicRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Clinic not found"));

    clinicRepository.delete(clinic);
    return true;
  }
}

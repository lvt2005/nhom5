package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.model.Doctor;
import com.doctor_appointment.model.Specialization;
import com.doctor_appointment.model.UserEntity;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.repository.SpecializationRepository;
import com.doctor_appointment.repository.UserRepository;
import com.doctor_appointment.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
  private final DoctorRepository doctorRepository;
  private final UserRepository userRepository;
  private final SpecializationRepository specializationRepository;

  @Override
  public Long addDoctor(DoctorRequestDTO request) {
    log.info("Adding new doctor with email: {}", request.getEmail());

    if (userRepository.findByEmail(request.getEmail()).isPresent()){
      throw new IllegalArgumentException("Email already exits!");
    }


    UserEntity user = UserEntity.builder()
            .fullname(request.getFullname())
            .email(request.getEmail())
//            .password(passwordEncoder.encode(request.getPassword()))
            .status(request.getStatus())
            .gender(request.getGender())
            .dateOfBirth(request.getDateOfBirth())
            .type(request.getType())
            .phone(request.getPhone())
            .address(request.getAddress())
            .build();

    Specialization specialization = Specialization.builder()
            .name(request.getSpecialName())
            .description(request.getSpecialDesc())
            .build();

    Doctor doctor = Doctor.builder()
            .experience(request.getExperience())
            .user(user)
            .build();

    specialization.addDoctor(doctor);
    specializationRepository.save(specialization);

    user.setDoctor(doctor);
    userRepository.save(user);

    log.info("Doctor {} added successfully with ID {}", request.getFullname(), doctor.getId());
    return doctor.getId();
  }



}

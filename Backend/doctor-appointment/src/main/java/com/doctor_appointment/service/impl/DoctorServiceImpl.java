package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.dto.response.DoctorDetailResponse;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.exception.ResourceNotFoundException;
import com.doctor_appointment.mapper.UserMapper;
import com.doctor_appointment.model.*;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.repository.SpecializationRepository;
import com.doctor_appointment.service.DoctorService;
import com.doctor_appointment.service.UserService;
import com.doctor_appointment.util.Status;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
  private final DoctorRepository doctorRepository;
  private final SpecializationRepository specializationRepository;
  private final UserMapper userMapper;
  private final UserService userService;


  @Override
  public Integer updateDoctor(Integer doctorId, DoctorRequestDTO request) {
    log.info("Updating doctor profile for doctorId = {}", doctorId);
    Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for userId: " + doctorId));

    UserEntity user = doctor.getUser();
    userMapper.updateUserFromDto(request, user);

    userService.updateUserRoles(user,request.getRoleId());

    doctor.setExperience(request.getExperience());
    doctor.setDescription(request.getDoctorDesc());

    if(request.getSpecialId() != null ){
      var specialization =  specializationRepository.findById(request.getSpecialId())
              .orElseThrow(() -> new ResourceNotFoundException("Specialization not found"));
      doctor.setSpecialization(specialization);
    }

    doctorRepository.save(doctor);

    log.info("Doctor and User updated successfully for userId = {}", doctorId);
    return doctor.getId();
  }

  @Override
  public PageResponse<?> getAllDoctorsWithSortBy(int pageNo, int pageSize, String sortBy) {
    if (pageNo > 0) {
      pageNo = pageNo - 1;
    }

    List<Sort.Order> sorts = new ArrayList<>();

    //If sortBy exits
    // Parse sortBy: "fullName:asc"
    if (StringUtils.hasLength(sortBy)) {
      Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");
      Matcher matcher = pattern.matcher(sortBy);
      if (matcher.find()) {
        if (matcher.group(3).equalsIgnoreCase("asc")) {
          sorts.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
        } else {
          sorts.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
        }
      }
    }

    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sorts));

    Page<Doctor> doctors = doctorRepository.findByDoctorStatus(Status.ACTIVE, pageable);

    List<DoctorDetailResponse> response = doctors.stream().map(doctor -> {
      UserEntity user = doctor.getUser();
      Specialization special = doctor.getSpecialization();

      return DoctorDetailResponse.builder()
              .doctorId(doctor.getId())
              .fullName(user.getFullname())
              .gender(user.getGender())
              .dateOfBirth(user.getDateOfBirth())
              .address(user.getAddress())
              .phone(user.getPhone())
              .email(user.getEmail())
              .status(user.getStatus())
              .type(user.getType())
              .experienceYear(doctor.getExperience())
              .ratingAvg(doctor.getRatingAvg())
              .specialName(special.getName())
              .specialDesc(special.getDescription())
              .build();
    }).toList();


    return PageResponse.<DoctorDetailResponse>builder()
            .pageNo(pageNo)
            .pageSize(pageSize)
            .totalPage(doctors.getTotalPages())
            .items(response)
            .build();
  }

  @Override
  public Boolean deleteDoctor(int doctorId) {
    Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for userId: " + doctorId));

    doctor.setDoctorStatus(Status.INACTIVE);
    doctorRepository.save(doctor);

    log.info("Successfully deleted doctor with ID: {}", doctorId);
    return true;
  }

}

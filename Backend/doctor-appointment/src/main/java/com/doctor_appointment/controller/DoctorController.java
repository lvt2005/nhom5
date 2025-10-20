package com.doctor_appointment.controller;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@Slf4j(topic = "DOCTOR-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Doctor Management", description = "APIs for managing doctor information")
public class DoctorController {
  private final DoctorService doctorService;

  //Add doctor
  @Operation(
          summary = "Add a new doctor",
          description = "Create a new doctor with specialization and user information")
  @PostMapping("/add")
  public ResponseData<?> add(@Validated @RequestBody DoctorRequestDTO request) {
    log.info("Add doctor: {}", request);

    try {
      return new ResponseData<>(HttpStatus.CREATED.value(), "Doctor added successfully", doctorService.addDoctor(request));

    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getCause());
    }
  }


}

package com.doctor_appointment.controller;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@Slf4j(topic = "DOCTOR-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Doctor Management", description = "APIs for managing doctor information")
public class DoctorController {
  private final DoctorService doctorService;


  @Operation(summary = "Get all doctors", description = "Get all doctors")
  @GetMapping("/list")
  public ResponseData<?> getAllDoctors(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                       @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize,
                                       @RequestParam(required = false) String sortBy){
    log.info("Get all doctors");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", doctorService.getAllDoctorsWithSortBy(pageNo, pageSize, sortBy));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }

  }

  @Operation(summary = "Delete a doctor", description = "Delete a doctor")
  @DeleteMapping("/delete/{doctorId}")
  public ResponseData<?> deleteDoctor(@PathVariable @Min(1) int doctorId){
    log.info("Delete a doctor");

    try {
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete a doctor", doctorService.deleteDoctor(doctorId));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }

  }

  //Update doctor
  @Operation(summary = "Update a doctor", description = "Update a doctor with specialization and user information")
  @PatchMapping("/update/{doctorId}")
  public ResponseData<?> update(@PathVariable @Min(1) Integer doctorId,
                                @Validated @RequestBody DoctorRequestDTO request) {
    log.info("Add doctor: {}", request);

    try {
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Doctor updated successfully", doctorService.updateDoctor(doctorId, request));

    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getCause());
    }
  }





}

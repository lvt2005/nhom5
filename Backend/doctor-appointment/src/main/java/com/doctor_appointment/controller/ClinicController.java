package com.doctor_appointment.controller;

import com.doctor_appointment.dto.request.ClinicRequestDTO;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.service.ClinicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinic")
@Slf4j(topic = "CLINIC-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Clinic Controller", description = "APIs for managing clinic")
public class ClinicController {
  private final ClinicService clinicService;

  @Operation(summary = "Add a new Clinic", description = "Create a new Clinic to database")
  @PostMapping("/add")
  public ResponseData<?> add(@RequestBody @Valid ClinicRequestDTO request) {
    log.info("Add a new Clinic");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", clinicService.addClinic(request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Update a Clinic", description = "Update a new Clinic to database")
  @PostMapping("/update/{id}")
  public ResponseData<?> updateClinic(@PathVariable @Min(1) int id,
                                @RequestBody @Valid ClinicRequestDTO request){
    log.info("Add a new Clinic");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", clinicService.updateClinic(id, request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Delete a Clinic", description = "Delete a Clinic from database")
  @DeleteMapping("/delete/{id}")
  public ResponseData<?> updateClinic(@PathVariable @Min(1) int id){
    log.info("Delete a Clinic");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", clinicService.deleteClinic(id));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }


}

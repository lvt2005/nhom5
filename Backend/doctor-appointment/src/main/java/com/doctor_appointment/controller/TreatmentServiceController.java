package com.doctor_appointment.controller;

import com.doctor_appointment.dto.request.TreatmentServiceDTO;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.service.TreatmentService;
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
@RequestMapping("/treatment-service")
@Slf4j(topic = "TREATMENT-SERVICE-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Treatment Service Management", description = "APIs for managing Treatment Service information")
public class TreatmentServiceController {

  private final TreatmentService treatmentService;

  @Operation(summary = "Add a new treatment service",
          description = "Creates and saves a new treatment service entity in the database")
  @PostMapping("/add")
  public ResponseData<?> add(@RequestBody @Valid TreatmentServiceDTO request) {
    log.info("Add a new treatment service");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", treatmentService.addService(request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Update a  treatment service",
          description = "Update and saves a treatment service entity")
  @PutMapping("/update")
  public ResponseData<?> update(@RequestBody @Valid TreatmentServiceDTO request) {
    log.info("Update treatment service");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", treatmentService.updateService(request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Delete a  treatment service",
          description = "Delete a treatment service entity")
  @DeleteMapping("/delete/{id}")
  public ResponseData<?> delete(@PathVariable @Min(1) int id) {
    log.info("Delete treatment service");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all doctors", treatmentService.deleteService(id));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }
}

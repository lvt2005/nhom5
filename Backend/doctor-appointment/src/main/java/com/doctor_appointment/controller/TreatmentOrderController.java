package com.doctor_appointment.controller;


import com.doctor_appointment.dto.request.TreatmentOrderRequest;
import com.doctor_appointment.dto.response.ResponseData;
import com.doctor_appointment.dto.response.ResponseError;
import com.doctor_appointment.model.TreatmentOrder;
import com.doctor_appointment.service.TreatmentOrderService;
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
@RequestMapping("/doctor")
@Slf4j(topic = "TREATMENT-ORDER-CONTROLLER")
@RequiredArgsConstructor
@Validated
@Tag(name = "Treatment Order Management", description = "APIs for managing treatment order")
public class TreatmentOrderController {

  private final TreatmentOrderService treatmentOrderService;

  @Operation(summary = "Get all treatment orders", description = "Get all treatment orders from database")
  @GetMapping("/list")
  public ResponseData<?> getAllTreatmentOrders(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                       @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize,
                                       @RequestParam(required = false) String sortBy){
    log.info("Get all treatment orders");

    try{
      return new ResponseData<>(HttpStatus.OK.value(), "Get all treatment orders with sort", treatmentOrderService.getAllTreatmentOrdersWithSortBy(pageNo, pageSize, sortBy));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Create a new treatment order", description = "Create a new treatment order and save to database")
  @PostMapping("/add")
  public ResponseData<?> addTreatmentOrder(@RequestBody @Valid TreatmentOrderRequest request){
    log.info("Create a new treatment order");

    try{
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Create a new treatment order", treatmentOrderService.addTreatmentOrder(request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }

  @Operation(summary = "Change status of treatment orders", description = "Change status of treatment orders and save to database")
  @PatchMapping("/status/{orderId}")
  public ResponseData<?> changeStatus(@PathVariable @Min(1) Long orderId,
                                      @RequestBody @Valid TreatmentOrderRequest request){
    log.info("Change status of treatment orders");

    try{
      return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Change status of treatment orders", treatmentOrderService.changeStatus(orderId, request));
    } catch (Exception e) {
      log.error("errorMessage={}", e.getMessage(), e.getCause());
      return new ResponseError(HttpStatus.BAD_REQUEST.value(), "error", e.getMessage());
    }
  }




}

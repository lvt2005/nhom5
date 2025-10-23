package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.TreatmentOrderRequest;
import com.doctor_appointment.dto.response.DoctorDetailResponse;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.TreatmentOrderDetailResponse;
import com.doctor_appointment.exception.DuplicateResourceException;
import com.doctor_appointment.exception.ResourceNotFoundException;
import com.doctor_appointment.model.*;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.repository.TreatmentOrderRepository;
import com.doctor_appointment.repository.TreatmentServiceRepository;
import com.doctor_appointment.repository.UserRepository;
import com.doctor_appointment.service.TreatmentOrderService;
import com.doctor_appointment.util.Status;
import com.doctor_appointment.util.StatusPayment;
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

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TreatmentOrderServiceImpl implements TreatmentOrderService {
  private final TreatmentOrderRepository treatmentOrderRepository;
  private final DoctorRepository doctorRepository;
  private final UserRepository userRepository;
  private final TreatmentServiceRepository treatmentServiceRepository;

  @Override
  public PageResponse<?> getAllTreatmentOrdersWithSortBy(int pageNo, int pageSize, String sortBy) {
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

    Page<TreatmentOrder> orders = treatmentOrderRepository.findAll(pageable);

    List<TreatmentOrderDetailResponse> response = orders.stream().map(order -> {
        String serviceName = order.getService().getName();
      StatusPayment payment = order.getPayment().getStatus();
      Integer doctorId = order.getDoctor().getId();
      Long userId = order.getUser().getId();

      return TreatmentOrderDetailResponse.builder()
              .id(order.getId())
              .appointmentDate(order.getAppointmentDate())
              .note(order.getNote())
              .serviceName(order.getService().getName())
              .status(order.getStatus())
              .statusPayment(order.getPayment().getStatus())
              .doctorId(order.getDoctor().getId())
              .userID(order.getUser().getId())
              .build();
    }).toList();


    return PageResponse.<TreatmentOrderDetailResponse>builder()
            .pageNo(pageNo)
            .pageSize(pageSize)
            .totalPage(orders.getTotalPages())
            .items(response)
            .build();
  }

  @Override
  public Long changeStatus(Long orderId, TreatmentOrderRequest request) {
    TreatmentOrder order = treatmentOrderRepository.findById(orderId)
            .orElseThrow(()-> new ResourceNotFoundException("Order Not Found"));

    order.setStatus(request.getAppointmentStatus());
    log.info("Changed status of treatment order!");
    return order.getId();
  }

  @Override
  public Long addTreatmentOrder(TreatmentOrderRequest request) {

    Doctor doctor = doctorRepository.findById(request.getDoctorId())
            .orElseThrow(()-> new ResourceNotFoundException("Doctor Not Found"));

    if (treatmentOrderRepository.existsConflictingAppointment(doctor, request.getAppointmentDate())) {
      throw new DuplicateResourceException("Bác sĩ đã có lịch hẹn vào thời gian này.");
    }

    UserEntity user = userRepository.findById(request.getUserId())
            .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

    TreatmentServiceEntity service = treatmentServiceRepository.findById(request.getServiceId())
            .orElseThrow(()-> new ResourceNotFoundException("Service Not Found"));

    TreatmentOrder order = TreatmentOrder.builder()
            .appointmentDate(request.getAppointmentDate())
            .note(request.getNote())
            .status(request.getAppointmentStatus())
            .service(service)
            .doctor(doctor)
            .user(user)
            .build();


    treatmentOrderRepository.save(order);
    log.info("Added treatment order!");
    return order.getId();
  }

}

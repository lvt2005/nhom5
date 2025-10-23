package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.TreatmentOrderRequest;
import com.doctor_appointment.dto.response.PageResponse;
import org.springframework.data.domain.Page;

public interface TreatmentOrderService{
  PageResponse<?> getAllTreatmentOrdersWithSortBy(int pageNo, int pageSize, String sortBy);
  Long changeStatus(Long orderId, TreatmentOrderRequest request);
  Long addTreatmentOrder(TreatmentOrderRequest request);
}

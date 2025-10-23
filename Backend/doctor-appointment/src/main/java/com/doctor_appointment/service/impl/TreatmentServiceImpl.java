package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.TreatmentServiceDTO;
import com.doctor_appointment.exception.DuplicateResourceException;
import com.doctor_appointment.exception.ResourceNotFoundException;
import com.doctor_appointment.mapper.TreatmentServiceMapper;
import com.doctor_appointment.model.TreatmentServiceEntity;
import com.doctor_appointment.repository.TreatmentServiceRepository;
import com.doctor_appointment.service.TreatmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TreatmentServiceImpl implements TreatmentService {
  private final TreatmentServiceRepository serviceRepository;
  private final TreatmentServiceMapper serviceMapper;

  @Override
  public Boolean addService(TreatmentServiceDTO request) {
    String serviceName = request.getName().trim();
    if(serviceRepository.existsByName(serviceName)){
      throw new DuplicateResourceException("Treatment Service with name '" + serviceName + "' already exists.");
    }

    serviceRepository.save(serviceMapper.toEntity(request));
    return true;
  }

  @Override
  public Boolean updateService(TreatmentServiceDTO request) {
    log.info("Updating Treatment Service with name '{}'.", request.getName().trim());

    TreatmentServiceEntity treatmentService = getTreatmentService(request.getName());

    treatmentService.setName(request.getName());
    treatmentService.setDescription(request.getDescription());
    treatmentService.setPrice(request.getPrice());
    treatmentService.setDurationMinutes(request.getDurationMinutes());
    treatmentService.setIsActive(request.getIsActive());
    serviceRepository.save(treatmentService);

    log.info("Updated Treatment Service with name '{}'.", request.getName().trim());
    return true;
  }

  @Override
  public Boolean deleteService(int id) {
    log.info("Deleting Treatment Service with id '{}'.", id);
    TreatmentServiceEntity treatmentService = serviceRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Treatment Service with id '" + id + "' not found."));

    serviceRepository.delete(treatmentService);
    log.info("Deleted Treatment Service with id = {}", id);
    return true;
  }


  private TreatmentServiceEntity getTreatmentService(String name) {
    return serviceRepository.findByName(name)
           .orElseThrow(()-> new ResourceNotFoundException("Treatment Service with name '" +name + "' not found."));
  }

}


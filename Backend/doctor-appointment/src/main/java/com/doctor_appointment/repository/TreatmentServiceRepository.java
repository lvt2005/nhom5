package com.doctor_appointment.repository;

import com.doctor_appointment.controller.TreatmentServiceController;
import com.doctor_appointment.model.TreatmentServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreatmentServiceRepository extends JpaRepository<TreatmentServiceEntity, Integer> {

  boolean existsByName(String serviceName);

  Optional<TreatmentServiceEntity> findByName(String serviceName);
}

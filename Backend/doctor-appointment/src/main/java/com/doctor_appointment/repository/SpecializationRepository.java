package com.doctor_appointment.repository;

import com.doctor_appointment.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;
import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
  Optional<Specialization> findById(Integer specialId);
}

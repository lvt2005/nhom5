package com.doctor_appointment.repository;

import com.doctor_appointment.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
}

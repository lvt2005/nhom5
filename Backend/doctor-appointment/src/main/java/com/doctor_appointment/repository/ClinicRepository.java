package com.doctor_appointment.repository;

import com.doctor_appointment.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
}

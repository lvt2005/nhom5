package com.doctor_appointment.repository;

import com.doctor_appointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}

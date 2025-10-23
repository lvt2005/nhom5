package com.doctor_appointment.repository;

import com.doctor_appointment.model.Doctor;
import com.doctor_appointment.util.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

  Optional<Doctor> findById(Integer doctorId);

  Page<Doctor> findByDoctorStatus(Status status, Pageable pageable);

}

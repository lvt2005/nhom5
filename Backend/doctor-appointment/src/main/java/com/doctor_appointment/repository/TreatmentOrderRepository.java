package com.doctor_appointment.repository;

import com.doctor_appointment.model.Doctor;
import com.doctor_appointment.model.TreatmentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TreatmentOrderRepository extends JpaRepository<TreatmentOrder, Long> {
  Optional<TreatmentOrder> findById(Long id);
  @Query("SELECT COUNT(o) > 0 FROM TreatmentOrder o WHERE o.doctor = :doctor AND o.status IN ('PENDING', 'CONFIRMED') AND o.appointmentDate = :appointmentDate")
  boolean existsConflictingAppointment(@Param("doctor") Doctor doctor, @Param("appointmentDate") LocalDateTime appointmentDate);
}

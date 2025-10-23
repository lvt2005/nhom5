package com.doctor_appointment.repository;

import com.doctor_appointment.model.UserHasRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasRoleRepository extends JpaRepository<UserHasRole, Integer> {
}

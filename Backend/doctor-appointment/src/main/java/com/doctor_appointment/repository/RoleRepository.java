package com.doctor_appointment.repository;

import com.doctor_appointment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findById(Integer id);
}

package com.doctor_appointment.repository;

import com.doctor_appointment.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findById(long id);

  Optional<UserEntity> findByEmail(String email);
}

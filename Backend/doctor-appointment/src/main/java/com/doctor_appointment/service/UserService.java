package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.UserDetailResponse;
import com.doctor_appointment.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface UserService {
  UserDetailResponse getUser(Long id);
  Long updateUser(Long id, UserRequestDTO request);
  PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy);
  Long saveUser(UserRequestDTO request);
  Long changeStatus(Long userId,UserRequestDTO request);

  void updateUserRoles(UserEntity user, Set<Integer> roleId);
}


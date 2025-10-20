package com.doctor_appointment.service;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.UserDetailResponse;
import org.springframework.stereotype.Service;


public interface UserService {
  UserDetailResponse getUser(Long id);
  Long updateUser(Long id, UserRequestDTO request);
  PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy);
  Long saveUser(UserRequestDTO request);
  Long changeStatus(Long userId,UserRequestDTO request);
}


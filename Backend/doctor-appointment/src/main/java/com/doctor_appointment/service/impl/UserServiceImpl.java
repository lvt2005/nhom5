package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.UserDetailResponse;
import com.doctor_appointment.model.UserEntity;
import com.doctor_appointment.repository.UserRepository;
import com.doctor_appointment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public UserDetailResponse getUser(Long id) {
    UserEntity user = getUserById(id);

    return UserDetailResponse.builder()
            .id(user.getId())
            .fullname(user.getFullname())
            .email(user.getEmail())
            .phone(user.getPhone())
            .address(user.getAddress())
            .status(user.getStatus())
            .gender(user.getGender())
            .dateOfBirth(user.getDateOfBirth())
            .build();
  }

  @Override
  public Long updateUser(Long id, UserRequestDTO request) {

    UserEntity user = getUserById(id);

    user.setFullname(request.getFullname());
    user.setEmail(request.getEmail());
    user.setPhone(request.getPhone());
    user.setAddress(request.getAddress());
    user.setDateOfBirth(request.getDateOfBirth());
    user.setGender(request.getGender());
    user.setAvatarUrl(request.getAvatarUrl());

    userRepository.save(user);

    return user.getId();
  }

  @Override
  public PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy) {
    if(pageNo > 0){
      pageNo = pageNo - 1;
    }

    List<Sort.Order> sorts = new ArrayList<>();

    //If sortBy exits
    if(StringUtils.hasLength(sortBy)){
      Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");
      Matcher matcher = pattern.matcher(sortBy);
      if (matcher.find()) {
        if (matcher.group(3).equalsIgnoreCase("asc")) {
          sorts.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
        } else {
          sorts.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
        }
      }
    }

    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sorts));

    Page<UserEntity> users = userRepository.findAll(pageable);

    List<UserDetailResponse> response = users.stream().map(user -> UserDetailResponse.builder()
            .fullname(user.getFullname())
            .email(user.getPhone())
            .phone(user.getPhone())
            .build()).toList();

    return PageResponse.<UserDetailResponse>builder()
            .pageNo(pageNo)
            .pageSize(pageSize)
            .totalPage(users.getTotalPages())
            .items(response)
            .build();
  }

  @Override
  public Long saveUser(UserRequestDTO request) {
    UserEntity user = UserEntity.builder()
            .fullname(request.getFullname())
            .email(request.getEmail())
            .phone(request.getPhone())
            .address(request.getAddress())
            .dateOfBirth(request.getDateOfBirth())
            .gender(request.getGender())
            .avatarUrl(request.getAvatarUrl())
            .status(request.getStatus())
            .type(request.getType())
            .build();

    userRepository.save(user);

    log.info("User saved {}", user);
    return user.getId();
  }

  @Override
  public Long changeStatus(Long userId, UserRequestDTO request) {
    UserEntity user = getUserById(userId);

    user.setStatus(request.getStatus());

    userRepository.save(user);

    return user.getId();
  }

  private UserEntity getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}

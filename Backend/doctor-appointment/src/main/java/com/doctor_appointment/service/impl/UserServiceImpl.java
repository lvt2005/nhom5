package com.doctor_appointment.service.impl;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.dto.response.PageResponse;
import com.doctor_appointment.dto.response.UserDetailResponse;
import com.doctor_appointment.exception.ResourceNotFoundException;
import com.doctor_appointment.model.*;
import com.doctor_appointment.repository.DoctorRepository;
import com.doctor_appointment.repository.RoleRepository;
import com.doctor_appointment.repository.SpecializationRepository;
import com.doctor_appointment.repository.UserRepository;
import com.doctor_appointment.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.doctor_appointment.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserMapper userMapper;
  private final SpecializationRepository specializationRepository;
  private final DoctorRepository doctorRepository;

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
    log.info("Updating user for userId={}", id);

    UserEntity user = getUserById(id);

    userMapper.updateUserFromDto(request, user);
    updateUserRoles(user, request.getRoleId());

    userRepository.save(user);

    log.info("User updated successfully: userId={}", id);
    return user.getId();
  }

  @Override
  public PageResponse<?> getAllUsersWithSortBy(int pageNo, int pageSize, String sortBy) {
    if (pageNo > 0) {
      pageNo = pageNo - 1;
    }

    List<Sort.Order> sorts = new ArrayList<>();

    //If sortBy exits
    if (StringUtils.hasLength(sortBy)) {
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

    UserEntity user = new UserEntity();
    userMapper.updateUserFromDto(request, user);
    updateUserRoles(user, request.getRoleId());
    userRepository.save(user);

   for(Integer roleId : request.getRoleId()) {
     if(Objects.equals(roleId, 2)){
       Doctor doctor = new Doctor();
       Specialization specialization = specializationRepository.findById(request.getSpecialId())
               .orElseThrow(() -> new ResourceNotFoundException("Specialization not found"));
       doctor.setUser(user);
       doctor.setSpecialization(specialization);
       doctorRepository.save(doctor);
       log.info("Doctor record created for user {}", user.getId());
       break;
     }
   }

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

  @Override
  public void updateUserRoles(UserEntity user, Set<Integer> roleId) {

    if (roleId == null || roleId.isEmpty()) {
      return;
    };

    Set<UserHasRole> newRoles = roleId.stream().map(id -> {
      Role role = roleRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleId));

      UserHasRole userHasRole = new UserHasRole();
      userHasRole.setUser(user);
      userHasRole.setRole(role);
      return userHasRole;
    }).collect(Collectors.toSet());

    user.getUserHasRoles().clear();
    user.setUserHasRoles(newRoles);
  }

  private UserEntity getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}

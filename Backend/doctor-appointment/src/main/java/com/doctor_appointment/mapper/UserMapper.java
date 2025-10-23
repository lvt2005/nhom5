package com.doctor_appointment.mapper;

import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "id", ignore = true) // không ghi đè ID
  void updateUserFromDto(UserRequestDTO dto, @MappingTarget UserEntity user);
}

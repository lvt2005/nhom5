package com.doctor_appointment.mapper;

import com.doctor_appointment.dto.request.DoctorRequestDTO;
import com.doctor_appointment.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
  void updateEntityFromDTO(DoctorRequestDTO dto, @MappingTarget Doctor doctor);
}

package com.doctor_appointment.mapper;

import com.doctor_appointment.dto.request.TreatmentServiceDTO;
import com.doctor_appointment.dto.request.UserRequestDTO;
import com.doctor_appointment.model.TreatmentServiceEntity;
import com.doctor_appointment.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring", uses = {})
public interface TreatmentServiceMapper {

  @Mapping(target = "isActive", source = "isActive", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  TreatmentServiceEntity toEntity(TreatmentServiceDTO dto);

  @Mapping(target = "id", ignore = true) // không ghi đè ID
  void updateTreatmentServiceFromDto(TreatmentServiceDTO dto, @MappingTarget TreatmentServiceEntity treatmentService);

}


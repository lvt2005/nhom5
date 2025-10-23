package com.doctor_appointment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentServiceDTO implements Serializable {

  @NotBlank(message = "service name must be not blank")
  private String name;

  private String description;

  @NotBlank(message = "price must be not blank")
  private String price;

  @NotNull(message = "durationMinutes must be not null")
  private int durationMinutes;

  private Boolean isActive = true;
}

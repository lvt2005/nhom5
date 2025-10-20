package com.doctor_appointment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_permission")
@Entity(name = "Permission")
public class Permission extends AbstractEntity<Integer> {

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "permission", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<RoleHasPermission> roles = new HashSet<>();
}

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
@Table(name = "tbl_role")
@Entity(name = "role")
public class Role extends AbstractEntity<Integer> {

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<UserHasRole> users = new HashSet<>();

  @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<RoleHasPermission> permissions = new HashSet<>();

  @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Group> groups = new HashSet<>();


}

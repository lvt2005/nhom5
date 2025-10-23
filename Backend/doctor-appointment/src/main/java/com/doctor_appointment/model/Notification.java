package com.doctor_appointment.model;

import com.doctor_appointment.util.NotificationType;
import com.doctor_appointment.util.Sent;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_notification")
@Entity(name = "Notification")
public class Notification extends AbstractEntity<Long>{


  @Column(name ="title" )
  private String title;

  @Column(name ="message" )
  private String message;

  @Column(name ="type" )
  private NotificationType type;

  @Column(name ="related_id" )
  private Long relatedId;

  @Column(name ="is_read" )
  private boolean isRead;

  @Column(name ="sent_via" )
  private Sent sentVia;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;
}

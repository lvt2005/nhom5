package com.doctor_appointment.model;

import com.doctor_appointment.util.TokenType;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_verification_tokens")
@Entity(name = "VerificationToken")
public class VerificationToken extends AbstractEntity<Long>{

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "token_type", nullable = false)
  private TokenType tokenType;

  @Column(name = "token_hash", nullable = false)
  private String tokenHash;

  @Column(name = "verification_code")
  private String verificationCode;

  @Column(name = "metadata", columnDefinition = "LONGTEXT")
  private String metadata;

  @Column(name = "ip_address", length = 45)
  private String ipAddress;

  @Column(name = "user_agent")
  private String userAgent;

  @Column(name = "is_active")
  private boolean isActive = true;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "used_at")
  private Date usedAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expires_at", nullable = false)
  private Date expiresAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;
}
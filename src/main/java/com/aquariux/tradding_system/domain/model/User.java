package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USER_ACCOUNT")
public class User {
  @Id
  private UUID id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  public User() {
    this.id = UUID.randomUUID();
    this.createdAt = LocalDateTime.now();
  }
}

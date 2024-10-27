package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "WALLET")
public class Wallet {

  @Id
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private String currency;

  @Column(nullable = false)
  private BigDecimal balance;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Wallet() {
    this.id = UUID.randomUUID();
    this.balance = BigDecimal.ZERO; // Default balance
    this.createdAt = LocalDateTime.now(); // Set created_at to the current time
    this.updatedAt = LocalDateTime.now(); // Set updated_at to the current time
  }
}

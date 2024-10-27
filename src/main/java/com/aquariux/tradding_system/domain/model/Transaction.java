package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TRANSACTION")
public class Transaction {
  @Id
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private String currencyPair;

  @Column(nullable = false)
  private String transactionType; // "BUY" or "SELL"

  @Column(nullable = false)
  private BigDecimal amount;

  @Column(nullable = false)
  private BigDecimal price;

  private BigDecimal total;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  public Transaction() {
    this.id = UUID.randomUUID();
    this.createdAt = LocalDateTime.now();
    this.total = getTotal();
  }

  public BigDecimal getTotal() {
    return amount.multiply(price);
  }
}


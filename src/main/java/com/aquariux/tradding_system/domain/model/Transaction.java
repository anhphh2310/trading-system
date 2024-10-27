package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TRANSACTION")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private String currencyPair;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TransactionType transactionType; // "BUY" or "SELL"

  @Column(nullable = false)
  private BigDecimal amount;

  @Column(nullable = false)
  private BigDecimal price;

  @Transient
  private BigDecimal total;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  public Transaction() {
    this.createdAt = LocalDateTime.now();
  }

  public BigDecimal getTotal() {
    return amount.multiply(price);
  }
}


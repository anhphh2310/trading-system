package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRICE")
public class Price {

  @Id
  @Column(name = "trading_pair")
  private String tradingPair;

  @Column(name = "bid_price")
  private double bidPrice;

  @Column(name = "ask_price")
  private double askPrice;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Price() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }
}

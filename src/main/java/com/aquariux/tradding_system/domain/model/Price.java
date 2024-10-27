package com.aquariux.tradding_system.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRICE")
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String exchange;

  @Column(name = "trading_pair")
  private String tradingPair;

  @Column(name = "bid_price")
  private double bidPrice;

  @Column(name = "ask_price")
  private double askPrice;
}

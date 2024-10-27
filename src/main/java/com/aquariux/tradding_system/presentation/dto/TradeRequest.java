package com.aquariux.tradding_system.presentation.dto;

import com.aquariux.tradding_system.domain.model.TransactionType;
import lombok.Getter;

@Getter
public class TradeRequest {
  private Long userId;
  private String currencyPair;
  private Double amount;
  private Double price;
  private TransactionType type;
}

package com.aquariux.tradding_system.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BinanceTicker {
  private String symbol;
  private double bidPrice;
  private double askPrice;
}

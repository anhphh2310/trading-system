package com.aquariux.tradding_system.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WalletInfo {
  private String username;
  private String currency;
  private BigDecimal balance;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}

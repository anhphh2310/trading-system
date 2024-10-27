package com.aquariux.tradding_system.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionHistory {
  private String username;
  private String transactionType;
  private BigDecimal amount;
  private BigDecimal price;
  private BigDecimal total;
  private LocalDateTime createdAt;
}

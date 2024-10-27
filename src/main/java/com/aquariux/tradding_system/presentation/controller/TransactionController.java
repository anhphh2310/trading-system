package com.aquariux.tradding_system.presentation.controller;

import com.aquariux.tradding_system.presentation.dto.TransactionHistory;
import com.aquariux.tradding_system.presentation.mapping.TransactionMapper;
import com.aquariux.tradding_system.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

  @Autowired
  private TransactionMapper transactionHistoryMapper;

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/history/{userId}")
  public List<TransactionHistory> getTransactionHistory(@PathVariable Long userId) {
    return transactionService.getTransactionByUserId(userId).stream()
        .map(transactionHistoryMapper::toTransactionHistory).collect(
            Collectors.toList());
  }
}

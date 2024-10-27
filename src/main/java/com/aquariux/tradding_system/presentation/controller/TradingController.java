package com.aquariux.tradding_system.presentation.controller;

import com.aquariux.tradding_system.presentation.dto.TradeRequest;
import com.aquariux.tradding_system.presentation.dto.TransactionHistory;
import com.aquariux.tradding_system.presentation.mapping.TransactionMapper;
import com.aquariux.tradding_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade")
public class TradingController {

  private TransactionService transactionService;
  private TransactionMapper transactionMapper;

  @Autowired
  public TradingController(TransactionService transactionService,
                           TransactionMapper transactionMapper) {
    this.transactionService = transactionService;
    this.transactionMapper = transactionMapper;
  }

  @PostMapping(value = "/execute", produces = "application/json")
  public TransactionHistory executeTrade(@RequestBody TradeRequest request) {
    return transactionMapper.toTransactionHistory(transactionService.executeTrade(request.getUserId(), request.getCurrencyPair(),
            request.getAmount(), request.getPrice(), request.getType()));
  }
}

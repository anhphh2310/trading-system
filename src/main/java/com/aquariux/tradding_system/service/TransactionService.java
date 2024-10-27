package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.Transaction;
import com.aquariux.tradding_system.domain.model.TransactionType;
import java.util.List;

public interface TransactionService {
  List<Transaction> getTransactionByUserId(Long userId);

  Transaction executeTrade(Long userId, String currencyPair, Double amount, Double price,
                           TransactionType type);
}

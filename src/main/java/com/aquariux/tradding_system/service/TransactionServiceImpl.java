package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.Transaction;
import com.aquariux.tradding_system.domain.model.TransactionType;
import com.aquariux.tradding_system.domain.model.User;
import com.aquariux.tradding_system.domain.model.Wallet;
import com.aquariux.tradding_system.domain.repository.TransactionRepository;
import com.aquariux.tradding_system.domain.repository.UserRepository;
import com.aquariux.tradding_system.domain.repository.WalletRepository;
import com.aquariux.tradding_system.infra.exception.UserNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

public class TransactionServiceImpl implements TransactionService {

  private TransactionRepository transactionRepository;
  private UserRepository userRepository;
  private WalletRepository walletRepository;

  public TransactionServiceImpl(UserRepository userRepository,
                                TransactionRepository transactionRepository,
                                WalletRepository walletRepository) {
    this.userRepository = userRepository;
    this.transactionRepository = transactionRepository;
    this.walletRepository = walletRepository;
  }

  @Override
  public List<Transaction> getTransactionByUserId(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (!user.isPresent()) {
      throw new UserNotFoundException(HttpStatus.NOT_FOUND.value(), "User not found!");
    }
    return transactionRepository.findByUserId(userId);
  }

  @Override
  public Transaction executeTrade(Long userId, String currencyPair, Double amount, Double price,
                                  TransactionType type) {
    Optional<User> optional = userRepository.findById(userId);
    if (!optional.isPresent()) {
      throw new UserNotFoundException(HttpStatus.NOT_FOUND.value(), "User not found!");
    }
    User user = optional.get();
    Wallet wallet = walletRepository.findByUserId(userId);
    if (type == TransactionType.BUY) {
      wallet.setBalance(BigDecimal.valueOf(wallet.getBalance().doubleValue() - (amount * price)));
    } else if (type == TransactionType.SELL) {
      wallet.setBalance(BigDecimal.valueOf(wallet.getBalance().doubleValue() + amount));
    }
    walletRepository.save(wallet);

    Transaction transaction = new Transaction();
    transaction.setUser(user);
    transaction.setCurrencyPair(currencyPair);
    transaction.setAmount(BigDecimal.valueOf(amount));
    transaction.setPrice(BigDecimal.valueOf(price));
    transaction.setTransactionType(type);
    transactionRepository.save(transaction);

    return transaction;
  }
}

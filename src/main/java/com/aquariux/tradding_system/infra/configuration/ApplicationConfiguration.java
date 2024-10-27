package com.aquariux.tradding_system.infra.configuration;

import com.aquariux.tradding_system.domain.repository.PriceRepository;
import com.aquariux.tradding_system.domain.repository.TransactionRepository;
import com.aquariux.tradding_system.domain.repository.UserRepository;
import com.aquariux.tradding_system.domain.repository.WalletRepository;
import com.aquariux.tradding_system.service.PriceService;
import com.aquariux.tradding_system.service.PriceServiceImpl;
import com.aquariux.tradding_system.service.TransactionService;
import com.aquariux.tradding_system.service.TransactionServiceImpl;
import com.aquariux.tradding_system.service.WalletService;
import com.aquariux.tradding_system.service.WalletServiceImpl;
import com.aquariux.tradding_system.service.scheduler.PriceScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {

  @Bean
  public TransactionService transactionService(UserRepository userRepository,
                                               TransactionRepository transactionRepository,
                                               WalletRepository walletRepository) {
    return new TransactionServiceImpl(userRepository, transactionRepository, walletRepository);
  }

  @Bean
  public WalletService walletService(WalletRepository walletRepository, UserRepository userRepository) {
    return new WalletServiceImpl(walletRepository, userRepository);
  }

  @Bean
  public PriceScheduler priceScheduler(ApiProperties apiProperties,
                                       PriceRepository priceRepository) {
    return new PriceScheduler(priceRepository, apiProperties);
  }

  @Bean
  public PriceService priceService(PriceRepository priceRepository) {
    return new PriceServiceImpl(priceRepository);
  }
}

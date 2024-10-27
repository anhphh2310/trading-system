package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
  Wallet findByUserId(Long userId);
}

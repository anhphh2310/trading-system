package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.Wallet;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, UUID> {
}

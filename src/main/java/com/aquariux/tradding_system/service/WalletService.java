package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.Wallet;

public interface WalletService {

  Wallet getWalletByUserId(Long userId);
}

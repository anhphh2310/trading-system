package com.aquariux.tradding_system.presentation.controller;

import com.aquariux.tradding_system.presentation.dto.WalletInfo;
import com.aquariux.tradding_system.presentation.mapping.WalletInfoMapper;
import com.aquariux.tradding_system.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

  private WalletInfoMapper mapper;
  private WalletService service;

  @Autowired
  public WalletController(WalletInfoMapper mapper, WalletService service) {
    this.mapper = mapper;
    this.service = service;
  }

  @GetMapping("/info/{userId}")
  public WalletInfo getWallet(@PathVariable("userId") Long userId) {
    return mapper.toWalletInfo(service.getWalletByUserId(userId));
  }
}

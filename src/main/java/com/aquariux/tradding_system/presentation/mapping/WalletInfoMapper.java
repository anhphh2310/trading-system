package com.aquariux.tradding_system.presentation.mapping;

import com.aquariux.tradding_system.domain.model.Wallet;
import com.aquariux.tradding_system.presentation.dto.WalletInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface WalletInfoMapper {

  @Mapping(source = "wallet", target = "username", qualifiedByName = "setUserName")
  WalletInfo toWalletInfo(Wallet wallet);

  @Named("setUserName")
  static String setUserName(Wallet wallet) {
    return wallet.getUser().getUsername();
  }
}

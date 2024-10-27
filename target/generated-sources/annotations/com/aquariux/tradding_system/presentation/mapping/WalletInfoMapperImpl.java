package com.aquariux.tradding_system.presentation.mapping;

import com.aquariux.tradding_system.domain.model.Wallet;
import com.aquariux.tradding_system.presentation.dto.WalletInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T22:56:45+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class WalletInfoMapperImpl implements WalletInfoMapper {

    @Override
    public WalletInfo toWalletInfo(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletInfo.WalletInfoBuilder walletInfo = WalletInfo.builder();

        walletInfo.username( WalletInfoMapper.setUserName( wallet ) );
        walletInfo.currency( wallet.getCurrency() );
        walletInfo.balance( wallet.getBalance() );
        walletInfo.createdAt( wallet.getCreatedAt() );
        walletInfo.updatedAt( wallet.getUpdatedAt() );

        return walletInfo.build();
    }
}

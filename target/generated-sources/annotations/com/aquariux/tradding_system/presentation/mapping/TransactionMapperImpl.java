package com.aquariux.tradding_system.presentation.mapping;

import com.aquariux.tradding_system.domain.model.Transaction;
import com.aquariux.tradding_system.presentation.dto.TransactionHistory;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-27T22:57:07+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionHistory toTransactionHistory(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionHistory.TransactionHistoryBuilder transactionHistory = TransactionHistory.builder();

        transactionHistory.username( TransactionMapper.setUserName( transaction ) );
        if ( transaction.getTransactionType() != null ) {
            transactionHistory.transactionType( transaction.getTransactionType().name() );
        }
        transactionHistory.amount( transaction.getAmount() );
        transactionHistory.price( transaction.getPrice() );
        transactionHistory.total( transaction.getTotal() );
        transactionHistory.createdAt( transaction.getCreatedAt() );

        return transactionHistory.build();
    }
}

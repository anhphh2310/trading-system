package com.aquariux.tradding_system.presentation.mapping;

import com.aquariux.tradding_system.domain.model.Transaction;
import com.aquariux.tradding_system.presentation.dto.TransactionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

  @Mapping(source = "transaction", target = "username", qualifiedByName = "setUserName")
  TransactionHistory toTransactionHistory(Transaction transaction);

  @Named("setUserName")
  static String setUserName(Transaction transaction) {
    return transaction.getUser().getUsername();
  }
}

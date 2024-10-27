package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.Transaction;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
  List<Transaction> findByUserId(Long userId);
}

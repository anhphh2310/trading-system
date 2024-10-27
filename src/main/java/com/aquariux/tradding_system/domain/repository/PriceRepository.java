package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}

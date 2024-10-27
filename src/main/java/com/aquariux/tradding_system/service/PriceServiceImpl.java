package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.Price;
import com.aquariux.tradding_system.domain.repository.PriceRepository;
import java.util.List;

public class PriceServiceImpl implements PriceService{

  private PriceRepository priceRepository;

  public PriceServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public List<Price> getLastest() {
    return (List<Price>) priceRepository.findAll();
  }
}

package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.Price;
import java.util.List;

public interface PriceService {

  List<Price> getLastest();
}

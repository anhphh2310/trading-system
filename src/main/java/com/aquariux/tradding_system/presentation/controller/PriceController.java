package com.aquariux.tradding_system.presentation.controller;

import com.aquariux.tradding_system.domain.model.Price;
import com.aquariux.tradding_system.domain.model.Transaction;
import com.aquariux.tradding_system.presentation.dto.ResponseMsg;
import com.aquariux.tradding_system.service.PriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

  private PriceService priceService;

  @Autowired
  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @GetMapping("/latest")
  public List<Price> getLastest() {
    return priceService.getLastest();
  }
}

package com.aquariux.tradding_system.service.scheduler;

import com.aquariux.tradding_system.domain.model.Price;
import com.aquariux.tradding_system.domain.repository.PriceRepository;
import com.aquariux.tradding_system.infra.configuration.ApiProperties;
import com.aquariux.tradding_system.presentation.dto.BinanceTicker;
import com.aquariux.tradding_system.presentation.dto.HuobiResponse;
import com.aquariux.tradding_system.presentation.dto.HuobiTicker;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class PriceScheduler {

  private PriceRepository priceRepository;
  private ApiProperties apiProperties;

  public PriceScheduler(PriceRepository priceRepository, ApiProperties apiProperties) {
    this.priceRepository = priceRepository;
    this.apiProperties = apiProperties;
  }

  private final RestTemplate restTemplate = new RestTemplate();


  @Scheduled(fixedRate = 10000)
  public void executeSchedulers() {
    List<BinanceTicker> binanceTickers = fetchBinancePrices();

    List<HuobiTicker> huobiTickers = fetchHuobiPrices();

    for (BinanceTicker binanceTicker : binanceTickers) {
      savePrice(binanceTicker.getSymbol(), binanceTicker.getBidPrice(), binanceTicker.getAskPrice());
    }

    for (HuobiTicker huobiTicker : huobiTickers) {
      savePrice(huobiTicker.getSymbol(), huobiTicker.getBidPrice(), huobiTicker.getAskPrice());
    }
  }

  private void savePrice(String currencyPair, double bestBid, double bestAsk) {
    Price price = new Price();
    price.setTradingPair(currencyPair);
    price.setBidPrice(bestBid);
    price.setAskPrice(bestAsk);
    priceRepository.save(price);
  }

  private List<BinanceTicker> fetchBinancePrices() {
    String binanceUrl = apiProperties.getBinance();
    BinanceTicker[] response = restTemplate.getForObject(binanceUrl, BinanceTicker[].class);
    return List.of(response);
  }

  private List<HuobiTicker> fetchHuobiPrices() {
    String huobiUrl = apiProperties.getHuobi();
    HuobiResponse response = restTemplate.getForObject(huobiUrl, HuobiResponse.class);
    return response.getData();
  }
}

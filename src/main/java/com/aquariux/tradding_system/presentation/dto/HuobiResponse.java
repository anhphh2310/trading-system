package com.aquariux.tradding_system.presentation.dto;

import java.util.List;

public class HuobiResponse {
  private List<HuobiTicker> data;

  public List<HuobiTicker> getData() {
    return data;
  }

  public void setData(List<HuobiTicker> data) {
    this.data = data;
  }
}


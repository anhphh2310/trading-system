package com.aquariux.tradding_system.presentation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties
public class ResponseMsg implements Serializable {
  private int code;
  private String message;
  private LocalDateTime timestamp;

  public ResponseMsg(int code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = LocalDateTime.now();
  }
}

package com.aquariux.tradding_system.infra.exception;

import com.aquariux.tradding_system.presentation.dto.ResponseMsg;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
  private int code;
  private String message;
  private LocalDateTime timestamp;

  public UserNotFoundException(int code, String message) {
    this.code = code;
    this.message = message;
    this.timestamp = LocalDateTime.now();;
  }
}

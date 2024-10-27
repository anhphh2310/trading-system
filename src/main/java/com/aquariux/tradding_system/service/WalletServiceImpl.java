package com.aquariux.tradding_system.service;

import com.aquariux.tradding_system.domain.model.User;
import com.aquariux.tradding_system.domain.model.Wallet;
import com.aquariux.tradding_system.domain.repository.UserRepository;
import com.aquariux.tradding_system.domain.repository.WalletRepository;
import com.aquariux.tradding_system.infra.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

public class WalletServiceImpl implements WalletService {

  private WalletRepository repository;
  private UserRepository userRepository;

  public WalletServiceImpl(WalletRepository repository, UserRepository userRepository) {
    this.repository = repository;
    this.userRepository = userRepository;
  }

  @Override
  public Wallet getWalletByUserId(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (!user.isPresent()) {
      throw new UserNotFoundException(HttpStatus.NOT_FOUND.value(), "User not found!");
    }
    return repository.findByUserId(userId);
  }
}

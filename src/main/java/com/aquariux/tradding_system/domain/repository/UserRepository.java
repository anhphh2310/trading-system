package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

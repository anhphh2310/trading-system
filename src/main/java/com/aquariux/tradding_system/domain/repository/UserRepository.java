package com.aquariux.tradding_system.domain.repository;

import com.aquariux.tradding_system.domain.model.User;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {
}

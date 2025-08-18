package com.hotelierpro.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will create the implementation for this method.
    // It will be used by our UserDetailsService to find a user by their username.
    Optional<User> findByUsername(String username);
}

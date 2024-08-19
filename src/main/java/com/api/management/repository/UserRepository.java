package com.api.management.repository;

import com.api.management.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);
}

package com.ecomm.repository;

import com.ecomm.models.Role;
import com.ecomm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByRolesContains(Role role);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

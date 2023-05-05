package com.rochiyat.spring.boot.jwt.postgresql.repository;

import java.util.Optional;

import com.rochiyat.spring.boot.jwt.postgresql.models.ERole;
import com.rochiyat.spring.boot.jwt.postgresql.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}

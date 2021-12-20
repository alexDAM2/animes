package com.example.animes.repository;

import com.example.animes.domain.dto.UserResult;
import com.example.animes.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Users findByUsername(String username);

    List<UserResult> findBy();
}

package com.kwizera.spring_boot_wallet_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwizera.spring_boot_wallet_api.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}

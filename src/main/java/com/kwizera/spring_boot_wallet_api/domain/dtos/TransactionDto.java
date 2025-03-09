package com.kwizera.spring_boot_wallet_api.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.kwizera.spring_boot_wallet_api.domain.enums.TransactionStatus;
import com.kwizera.spring_boot_wallet_api.domain.enums.TransactionType;

public record TransactionDto(
        UUID id,
        String description,
        TransactionStatus status,
        BigDecimal amount,
        AccountBriefDto accountAffected,
        TransactionType type,
        String category,
        LocalDateTime created_at) {

}

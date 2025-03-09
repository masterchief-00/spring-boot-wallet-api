package com.kwizera.spring_boot_wallet_api.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.kwizera.spring_boot_wallet_api.domain.enums.AccountType;
import com.kwizera.spring_boot_wallet_api.domain.enums.Providers;

public record AccountDto(
        UUID id,
        AccountType type,
        Long account_number,
        String holderNames,
        Providers provider,
        BigDecimal balance,
        LocalDateTime expiry_date,
        LocalDateTime created_at,
        Integer numberOfTransactions,
        BigDecimal totalExpenses) {

}

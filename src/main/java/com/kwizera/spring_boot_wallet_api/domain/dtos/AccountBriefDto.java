package com.kwizera.spring_boot_wallet_api.domain.dtos;

import java.util.UUID;

import com.kwizera.spring_boot_wallet_api.domain.enums.AccountType;
import com.kwizera.spring_boot_wallet_api.domain.enums.Providers;

public record AccountBriefDto(
        UUID id,
        AccountType type,
        Long account_number,
        Providers provider) {

}

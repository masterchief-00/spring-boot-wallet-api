package com.kwizera.spring_boot_wallet_api.domain.dtos;

import java.util.UUID;

public record CategoryDto(
        UUID id,
        String name,
        Long numberOfTransactions) {

}

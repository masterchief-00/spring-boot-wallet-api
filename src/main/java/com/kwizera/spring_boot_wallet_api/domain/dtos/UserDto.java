package com.kwizera.spring_boot_wallet_api.domain.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record UserDto(
        UUID id,
        String names,
        String avatar,
        String email,
        Integer numberOfAccounts,
        BigDecimal totalBalance) {

}

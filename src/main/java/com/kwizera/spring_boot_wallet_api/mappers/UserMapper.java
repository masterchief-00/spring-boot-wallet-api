package com.kwizera.spring_boot_wallet_api.mappers;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.kwizera.spring_boot_wallet_api.domain.dtos.UserDto;
import com.kwizera.spring_boot_wallet_api.domain.entities.AccountEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.UserEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "totalBalance", source = "accounts", qualifiedByName = "calculateBalance")
    @Mapping(target = "numberOfAccounts", source = "accounts", qualifiedByName = "calculateAccountCount")
    UserDto toDto(UserEntity userEntity);

    @Named("calculateAccountCount")
    default Integer calculateAccountCount(List<AccountEntity> accounts) {
        if (null == accounts)
            return 0;

        return accounts.size();
    }

    @Named("calculateBalance")
    default BigDecimal calculateBalance(List<AccountEntity> accounts) {
        if (null == accounts)
            return BigDecimal.ZERO;

        return accounts.stream()
                .map(AccountEntity::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

package com.kwizera.spring_boot_wallet_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.kwizera.spring_boot_wallet_api.domain.dtos.AccountBriefDto;
import com.kwizera.spring_boot_wallet_api.domain.dtos.TransactionDto;
import com.kwizera.spring_boot_wallet_api.domain.entities.AccountEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.CategoryEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.TransactionEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    @Mapping(target = "accountAffected", source = "account", qualifiedByName = "getAffectedAccount")
    @Mapping(target = "category", source = "category", qualifiedByName = "getCategoryName")
    TransactionDto toDto(TransactionEntity transactionEntity);

    @Named("getAffectedAccount")
    default AccountBriefDto getAffectedAccount(AccountEntity accountEntity) {
        return new AccountBriefDto(
                accountEntity.getId(),
                accountEntity.getType(),
                accountEntity.getAccount_number(),
                accountEntity.getProvider());
    }

    @Named("getCategoryName")
    default String getCategoryName(CategoryEntity categoryEntity) {
        return categoryEntity.getName();
    }
}

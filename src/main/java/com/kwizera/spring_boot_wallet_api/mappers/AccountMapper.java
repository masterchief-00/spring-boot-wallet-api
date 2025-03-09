package com.kwizera.spring_boot_wallet_api.mappers;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.kwizera.spring_boot_wallet_api.domain.dtos.AccountBriefDto;
import com.kwizera.spring_boot_wallet_api.domain.dtos.AccountDto;
import com.kwizera.spring_boot_wallet_api.domain.entities.AccountEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.TransactionEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.UserEntity;
import com.kwizera.spring_boot_wallet_api.domain.enums.TransactionType;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    @Mapping(target = "holderNames", source = "user", qualifiedByName = "getAccountHolder")
    @Mapping(target = "numberOfTransactions", source = "transactions", qualifiedByName = "calculateTransactionsCount")
    @Mapping(target = "totalExpenses", source = "transactions", qualifiedByName = "calculateExpensesTotal")
    AccountDto toDto(AccountEntity accountEntity);

    AccountBriefDto toBriefDto(AccountEntity accountEntity);

    @Named("getAccountHolder")
    default String getAccountHolder(UserEntity userEntity) {
        return userEntity.getNames();
    }

    @Named("calculateTransactionsCount")
    default Integer calculateTransactionsCount(List<TransactionEntity> transactions) {
        if (null == transactions)
            return 0;

        return transactions.size();
    }

    @Named("calculateExpensesTotal")
    default BigDecimal calculateExpensesTotal(List<TransactionEntity> transactions) {
        if (null == transactions)
            return BigDecimal.ZERO;

        return transactions.stream().filter(transaction -> TransactionType.DEBIT.equals(transaction.getType()))
                .map(TransactionEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

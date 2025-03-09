package com.kwizera.spring_boot_wallet_api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.kwizera.spring_boot_wallet_api.domain.dtos.CategoryDto;
import com.kwizera.spring_boot_wallet_api.domain.entities.CategoryEntity;
import com.kwizera.spring_boot_wallet_api.domain.entities.TransactionEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "numberOfTransactions", source = "transactions", qualifiedByName = "calculateTransactionsCount")
    CategoryDto toDto(CategoryEntity categoryEntity);

    @Named("calculateTransactionsCount")
    default Integer calculateTransactionsCount(List<TransactionEntity> transactions) {
        if (null == transactions)
            return 0;

        return transactions.size();
    }
}

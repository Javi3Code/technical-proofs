package org.jeycode.applicable_prices.infra.adapters.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.jeycode.applicable_prices.dom.models.ApplicablePrice;
import org.jeycode.applicable_prices.infra.repositories.entities.ApplicablePriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface ApplicablePriceEntityMapper {

  ApplicablePrice toDomainEntity(final ApplicablePriceEntity applicablePriceEntity);

}

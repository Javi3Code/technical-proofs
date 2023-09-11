package org.jeycode.applicable_prices.app.services.mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.jeycode.applicable_prices.dom.models.ApplicablePrice;
import org.jeycode.applicable_prices.dom.usecases.dtos.ApplicablePriceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface ApplicablePriceMapper {

  ApplicablePriceDto toDto(final ApplicablePrice applicablePrice);

}

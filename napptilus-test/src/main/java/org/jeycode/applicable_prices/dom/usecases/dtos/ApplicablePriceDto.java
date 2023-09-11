package org.jeycode.applicable_prices.dom.usecases.dtos;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record ApplicablePriceDto(int productId, int brandId, int applicableTariff, BigDecimal amount,
                                 ZonedDateTime startDate, ZonedDateTime endDate) {

}

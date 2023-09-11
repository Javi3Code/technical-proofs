package org.jeycode.applicable_prices.app.services;

import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeycode.applicable_prices.app.services.mappers.ApplicablePriceMapper;
import org.jeycode.applicable_prices.dom.ports.ApplicablePricePort;
import org.jeycode.applicable_prices.dom.usecases.ApplicablePriceSearchUseCase;
import org.jeycode.applicable_prices.dom.usecases.dtos.ApplicablePriceDto;
import org.jeycode.applicable_prices.dom.usecases.exceptions.ApplicablePriceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApplicablePriceSearchService implements ApplicablePriceSearchUseCase {

  private final ApplicablePriceMapper applicablePriceMapper;

  private final ApplicablePricePort applicablePriceManager;

  @Override
  public ApplicablePriceDto searchBy(final int brandId, final int productId, final ZonedDateTime applicationDate) {
    logger.info("Trying to search a applicable price with --> brandId [ {} ], productId [ {} ], applicationDate [ {} ]",
        brandId, productId, applicationDate);
    return applicablePriceManager.searchBy(brandId, productId, applicationDate)
        .map(applicablePriceMapper::toDto)
        .orElseThrow(ApplicablePriceNotFoundException::new);
  }
}

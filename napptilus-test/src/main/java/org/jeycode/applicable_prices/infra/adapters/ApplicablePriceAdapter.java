package org.jeycode.applicable_prices.infra.adapters;

import java.time.ZonedDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.jeycode.applicable_prices.dom.models.ApplicablePrice;
import org.jeycode.applicable_prices.dom.ports.ApplicablePricePort;
import org.jeycode.applicable_prices.infra.adapters.mappers.ApplicablePriceEntityMapper;
import org.jeycode.applicable_prices.infra.repositories.ApplicablePriceRepository;
import org.jeycode.applicable_prices.infra.repositories.utils.ApplicablePriceSearchSpecs;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class ApplicablePriceAdapter implements ApplicablePricePort {

  private final ApplicablePriceEntityMapper applicablePriceEntityMapper;
  private final ApplicablePriceRepository applicablePriceRepository;

  @Transactional
  @Override
  public Optional<ApplicablePrice> searchBy(
      final int brandId, final int productId, final ZonedDateTime applicationDate) {
    return applicablePriceRepository
        .findBy(
            ApplicablePriceSearchSpecs.by(brandId, productId, applicationDate),
            FetchableFluentQuery::first)
        .map(applicablePriceEntityMapper::toDomainEntity);
  }
}

package org.jeycode.applicable_prices.infra.repositories.utils;

import java.time.ZonedDateTime;
import lombok.experimental.UtilityClass;
import org.jeycode.applicable_prices.infra.repositories.entities.ApplicablePriceEntity;
import org.jeycode.applicable_prices.infra.repositories.entities.ApplicablePriceEntity_;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class ApplicablePriceSearchSpecs {

  public static Specification<ApplicablePriceEntity> by(
      final int brandId, final int productId, final ZonedDateTime applicationDate) {
    return byBrandId(brandId)
        .and(byProductId(productId))
        .and(byApplicationDate(applicationDate))
        .and(byHighestPriority());
  }

  private static Specification<ApplicablePriceEntity> byBrandId(final int brandId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(ApplicablePriceEntity_.brandId), brandId);
  }

  private static Specification<ApplicablePriceEntity> byProductId(final int productId) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.equal(root.get(ApplicablePriceEntity_.productId), productId);
  }

  private static Specification<ApplicablePriceEntity> byApplicationDate(
      final ZonedDateTime applicationDate) {
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.between(
            criteriaBuilder.literal(applicationDate),
            root.get(ApplicablePriceEntity_.startDate),
            root.get(ApplicablePriceEntity_.endDate));
  }

  private static Specification<ApplicablePriceEntity> byHighestPriority() {
    return (root, query, criteriaBuilder) ->
        query
            .orderBy(criteriaBuilder.desc(root.get(ApplicablePriceEntity_.priority)))
            .getRestriction();
  }
}

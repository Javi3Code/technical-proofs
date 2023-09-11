package org.jeycode.applicable_prices.dom.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jeycode.applicable_prices.dom.enums.CurrencyCode;

@AllArgsConstructor
@Builder
@Data
public class ApplicablePrice {

  private UUID id;
  private int brandId;
  private ZonedDateTime startDate;
  private ZonedDateTime endDate;
  private int applicableTariff;
  private int productId;
  private byte priority;
  private BigDecimal amount;
  private CurrencyCode currency;

}

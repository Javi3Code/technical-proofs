package org.jeycode.applicable_prices.dom.ports;

import java.time.ZonedDateTime;
import java.util.Optional;
import org.jeycode.applicable_prices.dom.models.ApplicablePrice;

public interface ApplicablePricePort {

  Optional<ApplicablePrice> searchBy(final int brandId, final int productId, final ZonedDateTime applicationDate);

}

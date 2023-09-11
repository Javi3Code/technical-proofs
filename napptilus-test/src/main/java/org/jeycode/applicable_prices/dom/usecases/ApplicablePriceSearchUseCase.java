package org.jeycode.applicable_prices.dom.usecases;

import java.time.ZonedDateTime;
import org.jeycode.applicable_prices.dom.usecases.dtos.ApplicablePriceDto;

public interface ApplicablePriceSearchUseCase {

  ApplicablePriceDto searchBy(final int brandId, final int productId, final ZonedDateTime applicationDate);
}

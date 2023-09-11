package org.jeycode.applicable_prices.api.controllers;

import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.jeycode.applicable_prices.dom.usecases.ApplicablePriceSearchUseCase;
import org.jeycode.applicable_prices.dom.usecases.dtos.ApplicablePriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApplicablePriceController {

  private final ApplicablePriceSearchUseCase applicablePriceSearchUseCase;

  @GetMapping("/v1/brands/{brandId}/products/{productId}/applicable-price")
  public ResponseEntity<ApplicablePriceDto> search(@PathVariable final int brandId, @PathVariable final int productId,
      @RequestParam final ZonedDateTime applicationDate) {
    return ResponseEntity.ok(applicablePriceSearchUseCase.searchBy(brandId, productId, applicationDate));
  }

}

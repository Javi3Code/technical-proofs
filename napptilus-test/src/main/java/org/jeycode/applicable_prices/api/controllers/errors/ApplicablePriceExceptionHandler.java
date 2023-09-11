package org.jeycode.applicable_prices.api.controllers.errors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.net.URI;
import org.jeycode.applicable_prices.dom.usecases.exceptions.ApplicablePriceNotFoundException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "org.jeycode.applicable_prices")
public class ApplicablePriceExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ApplicablePriceNotFoundException.class)
  ProblemDetail handleApplicablePriceNotFoundException(ApplicablePriceNotFoundException exception) {
    final var problemDetail = ProblemDetail.forStatusAndDetail(NOT_FOUND, exception.getMessage());
    problemDetail.setTitle("Applicable Price Not Found");
    problemDetail.setType(URI.create("/applicable-price/not-found"));
    return problemDetail;
  }
}

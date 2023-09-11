package org.jeycode.applicable_prices.dom.usecases.exceptions;


public class ApplicablePriceNotFoundException extends RuntimeException {

  private static final String MESSAGE = "No applicable price could be found";

  public ApplicablePriceNotFoundException() {
    super(MESSAGE);
  }

}

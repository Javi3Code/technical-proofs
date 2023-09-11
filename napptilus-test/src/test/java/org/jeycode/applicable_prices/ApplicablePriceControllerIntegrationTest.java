package org.jeycode.applicable_prices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class ApplicablePriceControllerIntegrationTest {

  private static final String URL = "/v1/brands/{brandId}/products/{productId}/applicable-price";
  private static final String APPLICATION_DATE_QPARAM = "applicationDate";
  @Autowired private MockMvc mockMvc;

  @CsvSource({
    "2020-06-14T10:00:00Z, 35.5",
    "2020-06-14T16:00:00Z, 25.45",
    "2020-06-14T21:00:00Z, 35.5",
    "2020-06-15T10:00:00Z, 30.5",
    "2020-06-16T21:00:00Z, 38.95"
  })
  @ParameterizedTest
  void test_when_price_is_requested_with_parameters_that_do_not_match_should_return_400(
      final String applicationDate, final BigDecimal expectedAmount) throws Exception {
    mockMvc
        .perform(get(URL, 1, 35455).param(APPLICATION_DATE_QPARAM, applicationDate))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.amount").value(expectedAmount));
  }

  @CsvSource(
      delimiter = ',',
      value = {
        "1,35455,",
        "aa,3545,2023-09-14T22:00:00Z",
        "1,aa,2023-09-14T22:00:00Z",
      })
  @ParameterizedTest
  void test_when_price_is_requested_with_parameters_that_do_not_match_should_return_400(
      final String brandId, final String productId, final String applicationDate) throws Exception {
    mockMvc
        .perform(get(URL, brandId, productId).param(APPLICATION_DATE_QPARAM, applicationDate))
        .andExpect(status().isBadRequest());
  }

  @CsvSource(
      delimiter = ',',
      value = {
        "1,35455,2023-09-14T22:00:00Z",
        ",35455,2023-09-14T22:00:00Z",
        "1,,2023-09-14T22:00:00Z",
      })
  @ParameterizedTest
  void test_that_when_requesting_the_non_existent_price_returns_a_404(
      final String brandId, final String productId, final String applicationDate) throws Exception {
    mockMvc
        .perform(get(URL, brandId, productId).param(APPLICATION_DATE_QPARAM, applicationDate))
        .andExpect(status().isNotFound());
  }
}

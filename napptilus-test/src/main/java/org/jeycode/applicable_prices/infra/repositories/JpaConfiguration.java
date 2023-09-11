package org.jeycode.applicable_prices.infra.repositories;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing(dateTimeProviderRef = "zonedDateTimeProvider")
@EnableJpaRepositories
@Configuration
public class JpaConfiguration {

  @Bean
  public DateTimeProvider zonedDateTimeProvider() {
    return () -> Optional.of(ZonedDateTime.now(ZoneOffset.UTC));
  }
}

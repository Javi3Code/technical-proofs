package org.jeycode.applicable_prices.infra.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;
import org.jeycode.applicable_prices.dom.enums.CurrencyCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "APPLICABLE_PRICE")
@Entity
public class ApplicablePriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "BRAND_ID")
  private int brandId;

  @Column(name = "START_DATE")
  private ZonedDateTime startDate;

  @Column(name = "END_DATE")
  private ZonedDateTime endDate;

  @Column(name = "APPLICABLE_TARIFF_ID")
  private int applicableTariff;

  @Column(name = "PRODUCT_ID")
  private int productId;

  @Column(name = "PRIORITY")
  @Default
  private byte priority = 0;

  @Column(name = "AMOUNT")
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(name = "CURRENCY")
  @Default
  private CurrencyCode currency = CurrencyCode.EUR;

  @CreatedDate
  @Column(name = "CREATED_AT", updatable = false)
  private ZonedDateTime createdAt;

  @LastModifiedDate
  @Column(name = "UPDATED_AT")
  private ZonedDateTime updatedAt;

  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy proxy
            ? proxy.getHibernateLazyInitializer().getPersistentClass()
            : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy proxy
            ? proxy.getHibernateLazyInitializer().getPersistentClass()
            : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    final ApplicablePriceEntity that = (ApplicablePriceEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy proxy
        ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
        : getClass().hashCode();
  }
}

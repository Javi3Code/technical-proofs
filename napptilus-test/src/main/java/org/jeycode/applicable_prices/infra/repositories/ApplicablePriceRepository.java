package org.jeycode.applicable_prices.infra.repositories;

import java.util.UUID;
import org.jeycode.applicable_prices.infra.repositories.entities.ApplicablePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicablePriceRepository
    extends JpaRepository<ApplicablePriceEntity, UUID>,
        JpaSpecificationExecutor<ApplicablePriceEntity> {}

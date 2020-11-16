package com.easyittech.phabillingservice.repository;

import com.easyittech.phabillingservice.domain.BillingDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BillingDrugRepository extends JpaRepository<BillingDrug,Long> {
}

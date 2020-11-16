package com.easyittech.phabillingservice.repository;

import com.easyittech.phabillingservice.domain.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BillingRepository extends JpaRepository<Billing,Long> {
}

package com.financial.transfers.repository;

import com.financial.transfers.entity.TransfersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfersRepository extends JpaRepository<TransfersEntity, Long> {
}

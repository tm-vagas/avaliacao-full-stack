package com.financial.transfers.repository;

import com.financial.transfers.entity.SavedAccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedAccountRepository extends JpaRepository<SavedAccountsEntity, Long> {
    SavedAccountsEntity findByAccountNumber(String targetAccount);
}

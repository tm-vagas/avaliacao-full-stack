package com.financial.transfers.repository;

import com.financial.transfers.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

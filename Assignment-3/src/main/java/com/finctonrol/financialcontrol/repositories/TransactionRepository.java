package com.finctonrol.financialcontrol.repositories;

import com.finctonrol.financialcontrol.models.TransactionEntity;


import com.finctonrol.financialcontrol.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByUserEntity(UserEntity userEntity);

}

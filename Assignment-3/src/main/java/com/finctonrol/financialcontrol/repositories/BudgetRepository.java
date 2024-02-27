package com.finctonrol.financialcontrol.repositories;

import com.finctonrol.financialcontrol.models.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {
}

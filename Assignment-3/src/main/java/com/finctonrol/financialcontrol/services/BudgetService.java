package com.finctonrol.financialcontrol.services;
import com.finctonrol.financialcontrol.models.BudgetEntity;
import com.finctonrol.financialcontrol.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {



    @Autowired
    private BudgetRepository budgetRepository;

    public BudgetEntity createBudget(BudgetEntity budget){
        return budgetRepository.save(budget);
    }

    public List<BudgetEntity> getAllBudgets(){
        return budgetRepository.findAll();
    }
}


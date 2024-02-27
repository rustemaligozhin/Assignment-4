package com.finctonrol.financialcontrol.services;

import com.finctonrol.financialcontrol.models.TransactionEntity;
import com.finctonrol.financialcontrol.models.UserEntity;
import com.finctonrol.financialcontrol.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserService userService){
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Transactional
    public TransactionEntity addTransaction(TransactionEntity transaction){
        return transactionRepository.save(transaction);
    }

    public List<TransactionEntity> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public List<TransactionEntity> getTransactionByUsername(String username){
        UserEntity user = userService.getUserByUsername(username);
        return transactionRepository.findByUserEntity(user);
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

}

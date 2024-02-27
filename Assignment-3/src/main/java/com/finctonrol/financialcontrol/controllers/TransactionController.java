package com.finctonrol.financialcontrol.controllers;

import com.finctonrol.financialcontrol.exception.UserExistException;
import com.finctonrol.financialcontrol.models.TransactionEntity;
import com.finctonrol.financialcontrol.models.UserEntity;
import com.finctonrol.financialcontrol.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity addTransaction(@Valid @RequestBody TransactionEntity transaction){
        try{
            transactionService.addTransaction(transaction);
            return ResponseEntity.ok("Transaction added");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to create transaction: " + e.getMessage());
        }


    }

    @GetMapping
    public ResponseEntity getAllTransactions(){
        List<TransactionEntity> transcations = transactionService.getAllTransactions();
        return ResponseEntity.ok(transcations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransaction(@PathVariable Long id){
        try {
            transactionService.deleteTransaction(id);
            return ResponseEntity.ok("Transaction deleted");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to delete Transaction" + e.getMessage());
        }
    }
}

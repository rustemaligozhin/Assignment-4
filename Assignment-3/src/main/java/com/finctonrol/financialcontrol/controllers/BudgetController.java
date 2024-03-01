package com.finctonrol.financialcontrol.controllers;
import com.finctonrol.financialcontrol.models.BudgetEntity;
import com.finctonrol.financialcontrol.services.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor@RequestMapping("api/budget")
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping
    public ResponseEntity addBudget(@Valid @RequestBody BudgetEntity budget) {
        try {
            budgetService.createBudget(budget);
            return ResponseEntity.ok("Budget added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create budget: " + e.getMessage());
        }
    }
}
package com.orcrist.springbootmongodbexample.controller;

import com.orcrist.springbootmongodbexample.model.Expense;
import com.orcrist.springbootmongodbexample.service.ExpenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenceService expenceService;

    public ExpenseController(ExpenceService expenceService) {
        this.expenceService = expenceService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenceService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenceService.updateExpense(expense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<List<Expense>> getAllExpense() {
        return ResponseEntity.ok(expenceService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity getExpenseByName(@PathVariable String name){
        return ResponseEntity.ok(expenceService.getExpense(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenceService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}

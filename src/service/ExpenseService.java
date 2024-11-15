package service;

import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;

import java.util.List;

public class ExpenseService implements ExpenseServiceInterface {

    private final ExpenseRepository expenseRepository;


    public ExpenseService(ExpenseRepository repository){
        this.expenseRepository = repository;
    }

    public double getTotalAmount(){
        return expenseRepository.getTotalAmount();
    }
    @Override
    public void addExpense(Expense expense) {
        //TODO:Create validation for expense
        throw new UnsupportedOperationException();
        //expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> getExpensesByCategory(ExpenseCategory category) {
        return expenseRepository.findByCategory(category);
    }
}

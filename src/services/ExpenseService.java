package services;

import factory.ExpenseFactory;
import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ExpenseService implements ExpenseServiceInterface {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository repository){
        this.expenseRepository = repository;
    }

    public double getTotalAmount(){
        return expenseRepository.getTotalAmount();
    }

    @Override
    public void addExpense(Scanner sc) {
        var expenseFactory = new ExpenseFactory(sc);
        Optional<Expense> expense = expenseFactory.getNewExpense();
        expense.ifPresent(expenseRepository::save);
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

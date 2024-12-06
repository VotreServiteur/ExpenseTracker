package services;

import factory.ExpenseFactory;
import io.InputHandler;
import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

public class ExpenseService implements ExpenseServiceInterface {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository repository){
        this.expenseRepository = repository;
    }

    public double getTotalAmount(){
        return expenseRepository.getTotalAmount();
    }

    @Override
    public void addExpense(InputHandler input) {
        var expenseFactory = new ExpenseFactory(input);
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

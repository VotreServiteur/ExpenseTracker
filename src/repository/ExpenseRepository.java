package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository implements ExpenseRepositoryInterface{
    private final List<Expense> expenses;


    public ExpenseRepository(List<Expense> expenses){
        this.expenses = expenses;
    }
    public ExpenseRepository(){
        this.expenses = new ArrayList<>();
    }

    private double getTotalAmount(){
        double sumOfExpenses = 0;
        assert this.expenses != null;
        for (var expense: this.expenses){
            sumOfExpenses += expense.getAmount();
        }
        return sumOfExpenses;
    }

    @Override
    public void save(Expense expense) {
        this.expenses.add(expense);
    }

    @Override
    public List<Expense> findAll() {
        return expenses;
    }

    @Override
    public List<Expense> findByCategory() {
        throw new UnsupportedOperationException();
    }
}

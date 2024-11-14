package repository;

import model.Expense;
import model.ExpenseCategory;

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

    public double getTotalAmount(){
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
    public List<Expense> findByCategory(ExpenseCategory category) {
        var expByCat = new ArrayList<Expense>();
        for (Expense e: this.expenses){
            if (e.getCategory().equals(category)){
                expByCat.add(e);
            }
        }
        return expByCat;
    }
}

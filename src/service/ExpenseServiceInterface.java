package service;

import model.Expense;
import model.ExpenseCategory;

import java.util.List;

public interface ExpenseServiceInterface {
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(ExpenseCategory category);
    Expense createExpense(double amount, ExpenseCategory category, String description);
}

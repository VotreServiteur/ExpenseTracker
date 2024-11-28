package services;

import model.Expense;
import model.ExpenseCategory;

import java.util.List;
import java.util.Scanner;

public interface ExpenseServiceInterface {
    void addExpense(Scanner sc);

    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(ExpenseCategory category);
}

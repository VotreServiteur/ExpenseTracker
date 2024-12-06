package services;

import io.InputHandler;
import model.Expense;
import model.ExpenseCategory;

import java.util.List;
import java.util.Scanner;

public interface ExpenseServiceInterface {
    void addExpense(InputHandler input);

    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(ExpenseCategory category);
}

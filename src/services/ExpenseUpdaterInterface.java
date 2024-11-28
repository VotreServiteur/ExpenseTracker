package services;

import model.Expense;

import java.util.Optional;

public interface ExpenseUpdaterInterface {
    Optional<Expense> getUpdatedExpense(Expense expense);
    boolean isNecessaryToRewriteExpense();
    void chooseOptionToRewrite(Expense expense);
}

package factory;

import io.InputHandler;
import model.Expense;
import services.ExpenseUpdater;

import java.util.Optional;

public class ExpenseFactory {
    private final InputHandler input;

    public ExpenseFactory(InputHandler input){
        this.input = input;
    }

    public Optional<Expense> getNewExpense() {
        double amount = input.getValidAmount();
        String description = input.getValidDescription();
        var category = input.getValidCategory();
        Expense expense = new Expense(amount, category, description);
        var option = input.askAboutValidity(expense);
        switch (option){
            case 1 -> {
                return Optional.of(expense);
            }
            case 2 -> {
                var updater = new ExpenseUpdater(input);
                return updater.getUpdatedExpense(expense);
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}

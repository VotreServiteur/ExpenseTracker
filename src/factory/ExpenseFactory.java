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

        while (true){
            System.out.print("""
                    Expense:
                        amount:\s"""
                        + amount +
                    "\n\tdescription: "
                        + description +
                    "\n\tcategory: " +
                        category.getNameOfCategory() +
                    """
                    \n
                    Is it correct?
                    1.Yes
                    2.No
                    3.Cancel
                    """);
            var option = input.askAboutValidity(expense);
            switch (option){
                case 1 -> {
                    return Optional.of(expense);
                }
                case 2 -> {
                    var updater = new ExpenseUpdater(input);
                    return updater.getUpdatedExpense(expense);
                }
                case 3 -> {
                    return Optional.empty();
                }
                default -> System.out.println("Choose correct option");
            }
        }
    }
}

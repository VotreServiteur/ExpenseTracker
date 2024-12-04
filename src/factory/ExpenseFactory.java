package factory;

import model.Expense;
import services.ExpenseUpdater;
import services.InputValidator;
import util.CategoryChooser;
import java.util.Optional;
import java.util.Scanner;

public class ExpenseFactory {
    private final Scanner sc;
    private final InputValidator validator;

    public ExpenseFactory(Scanner sc){
        this.sc = sc;
        validator = new InputValidator(sc);
    }

    public Optional<Expense> getNewExpense() {
        double amount = validator.getValidAmount();
        String description = validator.getValidDescription();
        var category = CategoryChooser.chooseCategory(sc);

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
            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 -> {
                    return Optional.of(expense);
                }
                case 2 -> {
                    var updater = new ExpenseUpdater(sc);
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

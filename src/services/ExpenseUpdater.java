package services;

import io.InputHandler;
import model.Expense;
import java.util.Optional;

public class ExpenseUpdater implements ExpenseUpdaterInterface{

    private final InputHandler input;

    public ExpenseUpdater(InputHandler input){
        this.input = input;
    }

    @Override
    public Optional<Expense> getUpdatedExpense(Expense expense) {
        if (isNecessaryToRewriteExpense()){
            chooseOptionToRewrite(expense);
            return Optional.of(expense);
        }else
            return Optional.empty();
    }

    @Override
    public void chooseOptionToRewrite(Expense expense) {
        while(true){
            System.out.println("\n" + expense.toString());
            System.out.print("""
                    Choose option to rewrite
                    1.Amount
                    2.Description
                    3.Category
                    0.Nothing
                    """);
            var option = input.askOptionToRewrite(expense);
            switch (option){
                case 1 -> expense.setAmount(input.getValidAmount());
                case 2 -> expense.setDescription(input.getValidDescription());
                case 3 -> expense.setCategory(input.getValidCategory());
                case 0 -> {
                    return;
                }
                default -> System.out.println("Choose correct option");
            }
        }
    }

    @Override
    public boolean isNecessaryToRewriteExpense(){
        while(true) {
            System.out.print("""
                    
                    Want to rewrite?:
                    1.Yes
                    2.No
                    """);
            var option = input.necessaryToRewriteOption();
            switch (option){
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> System.out.println("Choose correct option");
            }
        }
    }
}

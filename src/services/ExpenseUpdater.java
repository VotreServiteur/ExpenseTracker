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
        return input.askIfNecessaryToRewrite();
    }
}

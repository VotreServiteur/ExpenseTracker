package services;

import model.Expense;
import java.util.Optional;
import java.util.Scanner;

public class ExpenseUpdater implements ExpenseUpdaterInterface{

    private final Scanner sc;
    private final InputValidator validator;

    public ExpenseUpdater(Scanner sc){
        this.sc = sc;
        this.validator = new InputValidator(sc);
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
            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 -> expense.setAmount(validator.getValidAmount());
                case 2 -> expense.setDescription(validator.getValidDescription());
                case 3 -> expense.setCategory(validator.getValidCategory());
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
            var option = Integer.parseInt(sc.nextLine());
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

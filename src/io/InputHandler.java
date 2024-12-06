package io;

import model.Expense;
import model.ExpenseCategory;
import services.ExpenseInputHandler;

import java.util.Scanner;

public class InputHandler implements InputHandlerInterface {
    private final Scanner sc;
    private final ExpenseInputHandler expenseInput;
    public InputHandler(Scanner sc){
        this.sc = sc;
        expenseInput = new ExpenseInputHandler(this.sc);
    }

    @Override
    public boolean askToLoadExpenses() {
        return yesOrNoQuestion("Load expenses from file?");
    }

    @Override
    public boolean askToSaveExpenses() {
        return yesOrNoQuestion("Save expenses to file?");
    }

    @Override
    public boolean askIfNecessaryToRewrite() {
        return yesOrNoQuestion("Want to rewrite?:");
    }

    @Override
    public int getMenuOption() {
        return chooseOptionQuestion("""
                    
                    1. Show expenses
                    2. Sort by category
                    3. Add new expense
                    4. Get total amount
                    5. Save expenses
                    0. Exit
                    """, 0, 6);
    }

    @Override
    public int askOptionToRewrite(Expense expense) {
        return chooseOptionQuestion("\n" + expense.toString()+ "\n" +"""
                    Choose option to rewrite
                    1.Amount
                    2.Description
                    3.Category
                    0.Nothing
                    """, 0, 3);
    }
    @Override
    public int askAboutValidity(Expense expense) {
        return chooseOptionQuestion("""
                    Expense:
                        amount:\s"""
                                    + expense.getAmount() +
                                    "\n\tdescription: "
                                    + expense.getDescription() +
                                    "\n\tcategory: " +
                                    expense.getCategory().getNameOfCategory() +
                                    """
                                    \n
                                    Is it correct?
                                    1.Yes
                                    2.No
                                    3.Cancel
                                    """, 1, 3);
    }
    @Override
    public double getValidAmount() {
        return expenseInput.getValidAmount();
    }

    @Override
    public String getValidDescription() {
        return expenseInput.getValidDescription();
    }

    @Override
    public ExpenseCategory getValidCategory() {
        return expenseInput.getValidCategory();
    }

    @Override
    public boolean yesOrNoQuestion(String question){
        while (true){
            System.out.println(question +
                    "\n1.Yes" +
                    "\n2.No");
            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> System.out.println("Choose correct option.");
            }
        }
    }
    @Override
    public int chooseOptionQuestion(String question, int min, int max){
        while(true) {
            System.out.print(question);
            var option = Integer.parseInt(sc.nextLine());
            if (option >= min && option <= max) return option;
            else System.out.println("Choose correct option.");
        }
    }
}

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
        while(true) {
            System.out.print("""
                    Load expenses from file?
                    1. Yes
                    2. No
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

    @Override
    public int getMenuOption() {
        while(true) {
            System.out.print("""
                    
                    1. Show expenses
                    2. Sort by category
                    3. Add new expense
                    4. Get total amount
                    5. Save expenses
                    0. Exit
                    """);

            var option = Integer.parseInt(sc.nextLine());

            if (option >= 0 && option < 6) return option;

        }
    }

    @Override
    public boolean askToSaveExpenses() {
        return true;
    }

    @Override
    public int askOptionToRewrite() {
        return 0;
    }

    @Override
    public int necessaryToRewriteOption() {
        return 0;
    }

    @Override
    public double getValidAmount() {
        return 0;
    }

    @Override
    public String getValidDescription() {
        return "";
    }

    @Override
    public ExpenseCategory getValidCategory() {
        return null;
    }

    @Override
    public int askAboutValidity(Expense expense) {
        return 0;
    }
}

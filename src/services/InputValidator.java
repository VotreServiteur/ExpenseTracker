package services;

import model.ExpenseCategory;
import util.CategoryChooser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator implements InputValidatorInterface {
    private final Scanner sc;

    public InputValidator(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public double getValidAmount(){
        double amount;
        while (true) {
            try{
                System.out.print("Write your amount: ");
                amount = sc.nextDouble();
                sc.nextLine();

                if (amount < 0 || amount > 10000)
                    System.out.println("Incorrect amount");
                else
                    return amount;
            }catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    @Override
    public String getValidDescription() {
        String description;
        while (true) {
            System.out.print("Write your description: ");
            description = sc.nextLine();

            if (description.length() > 50 || description.length() < 3)
                System.out.println("Description is too long or too short");
            else
                return description;
        }
    }

    @Override
    public ExpenseCategory getValidCategory(){
        return CategoryChooser.chooseCategory(sc);
    }
}

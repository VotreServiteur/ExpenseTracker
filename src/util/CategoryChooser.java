package util;

import model.ExpenseCategory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CategoryChooser {
    public static ExpenseCategory chooseCategory(Scanner sc){
        var categories = ExpenseCategory.values();
        System.out.println("Choose category:");
        for (int i=0; i < categories.length; i++){
            System.out.printf("%d. %s\n",i + 1,categories[i].getNameOfCategory());
        }
        int cat;
        while(true)
            try {
                cat = sc.nextInt();
                if (cat < 1 || cat > categories.length){
                    throw new InputMismatchException();
                }else
                    break;
            }catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                System.out.println("Choose category:");

                sc.nextLine();
            }

        sc.nextLine();
        return categories[cat - 1];
    }
}

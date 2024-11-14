import model.ExpenseCategory;
import repository.ExpenseRepository;
import service.ExpenseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final ExpenseRepository expenseRepository = new ExpenseRepository();
        final ExpenseService expenseService = new ExpenseService(expenseRepository);

        while(true) {

            System.out.println("""
                    1. Show expenses
                    2. Sort by category
                    3. Add new expense
                    4. Get total amount
                    0. Exiting
                    """);

            int choice = sc.nextInt();

            switch (choice){
                case 1 -> showExpenses(expenseService);
                case 2 -> sortByCategory(expenseService);
                case 3 -> addNewExpense(expenseService);
                case (0) -> {
                    System.out.println("Exiting");
                    return;
                }
            }
        }
    }

    private static void addNewExpense(ExpenseService service) {
        throw new UnsupportedOperationException();

    }

    private static void sortByCategory(ExpenseService service) {
        ExpenseCategory category = chooseCategory();
        var expByCat = service.getExpensesByCategory(category);
        for (var exp: expByCat){
            System.out.println(exp.toString());
        }
    }

    private static ExpenseCategory chooseCategory(){
        Scanner sc = new Scanner(System.in);
        var categories = ExpenseCategory.values();
        System.out.println("Choose category:");
        for (int i=0; i < categories.length; i++){
            System.out.printf("%d. %s\n",i + 1,categories[i].getNameOfCategory());
        }
        int cat = sc.nextInt();
        return categories[cat];
    }

    public static void showExpenses(ExpenseService service){
        throw new UnsupportedOperationException();
    }
}
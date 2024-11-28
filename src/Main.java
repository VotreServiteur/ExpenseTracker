import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;
import services.ExpenseService;
import util.CategoryChooser;

import java.util.Scanner;
//TODO: refactor Main
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final ExpenseRepository expenseRepository = new ExpenseRepository();
        final ExpenseService expenseService = new ExpenseService(expenseRepository);

        while(true) {

            System.out.print("""
                    
                    1. Show expenses
                    2. Sort by category
                    3. Add new expense
                    4. Get total amount
                    0. Exit
                    :""");

            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                //TODO:Add description to no expense list
                case 1 -> showExpenses(expenseService);
                //TODO:Add description to no expense list
                case 2 -> sortByCategory(expenseService, sc);
                case 3 -> expenseService.addExpense(sc);
                case 4 -> System.out.println("Total amount is " + expenseService.getTotalAmount());
                case 0 -> {
                    System.out.println("Exiting");
                    return;
                }
            }
        }
    }

    private static void sortByCategory(ExpenseService service, Scanner sc) {
        ExpenseCategory category = CategoryChooser.chooseCategory(sc);
        var expByCat = service.getExpensesByCategory(category);
        for (var exp: expByCat){
            System.out.println(exp.toString());
        }
    }




    public static void showExpenses(ExpenseService service){
        for (Expense exp: service.getAllExpenses()){
            System.out.println(exp.toString());
        }
        System.out.println(service.getTotalAmount());
    }

}
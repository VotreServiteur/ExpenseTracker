import io.ExpenseReaderService;
import io.ExpenseWriterService;
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

        ExpenseService expenseService = null;

        boolean isAnswerChecked = false;
        while(!isAnswerChecked){
            System.out.print("""
                    Load expenses from file?
                    1. Yes
                    2. No
                    """);

            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 -> {
                    expenseService = loadExpensesFromFile();
                    isAnswerChecked = true;
                }
                case 2 ->{
                    expenseService = new ExpenseService(new ExpenseRepository());
                    isAnswerChecked = true;
                }
                default -> System.out.println("Choose correct option.");
            }
        }
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
            switch (option){
                case 1 -> showExpenses(expenseService);
                case 2 -> sortByCategory(expenseService, sc);
                case 3 -> expenseService.addExpense(sc);
                case 4 -> System.out.println("Total amount is " + expenseService.getTotalAmount());
                case 5 -> saveExpenses(sc, expenseService);
                case 0 -> {
                    saveExpenses(sc, expenseService);
                    return;
                }
            }
        }
    }

    private static void saveExpenses(Scanner sc, ExpenseService expenseService) {
        boolean isAnswerChecked = false;
        while(!isAnswerChecked){
            System.out.print("""
                    Save expenses to file?
                    1. Yes
                    2. No
                    """);

            var option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 -> {
                    ExpenseWriterService.writeExpensesToFile(expenseService.getAllExpenses());
                    isAnswerChecked = true;
                }
                case 2 -> isAnswerChecked = true;
                default -> System.out.println("Choose correct option.");
            }
        }
    }

    private static ExpenseService loadExpensesFromFile(){
        ExpenseRepository expenseRepository = new ExpenseRepository(ExpenseReaderService.readExpenses());
        return new ExpenseService(expenseRepository);
    }

    private static void sortByCategory(ExpenseService service, Scanner sc) {
        ExpenseCategory category = CategoryChooser.chooseCategory(sc);
        var expByCat = service.getExpensesByCategory(category);
        if (!expByCat.isEmpty())
            for (var exp: expByCat){
                System.out.println(exp.toString());
            }
        else System.out.println("There is no expenses in this category.");
    }

    public static void showExpenses(ExpenseService service) {
        var expenses = service.getAllExpenses();
        if (!expenses.isEmpty()) {
            for (Expense exp : expenses) {
                System.out.println(exp.toString());
            }
            System.out.println(service.getTotalAmount());
        }else System.out.println("There is no expenses.");
    }

}
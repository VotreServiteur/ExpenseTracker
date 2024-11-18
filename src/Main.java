import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;
import service.ExpenseService;

import java.util.InputMismatchException;
import java.util.Scanner;
//TODO: refactor main
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

            int choice = sc.nextInt();

            switch (choice){
                case 1 -> showExpenses(expenseService);
                case 2 -> sortByCategory(expenseService, sc);
                case 3 -> addNewExpense(expenseService, sc);
                case 4 -> System.out.println("Total amount is " + expenseService.getTotalAmount());
                case 0 -> {
                    System.out.println("Exiting");
                    return;
                }
            }
        }
    }
    //TODO: refactor method
    private static void addNewExpense(ExpenseService service, Scanner sc) {
            double amount;
            String description;

            while (true) {
                try{
                System.out.print("Write your amount: ");
                amount = sc.nextDouble();
                sc.nextLine();

                if (amount < 0 || amount > 10000)
                    System.out.println("Incorrect amount");
                else
                    break;
                }catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                }
            }
            while (true) {
                System.out.print("Write your description: ");
                description = sc.nextLine();

                if (description.length() > 50)
                    System.out.println("Description is too long");
                else
                    break;
            }

            var category = chooseCategory(sc);

            var expense = service.createExpense(amount, category, description);
            boolean isChoosed = false;
            while (!isChoosed){
                System.out.print(expense.toString() + "\nIs it correct?\n1.Yes\n2.No\n:");
                switch (sc.nextInt()) {
                    case 1 -> {
                        service.addExpense(expense);
                        isChoosed = true;
                    }
                    //TODO: create editing of expense with mistakes
                    case 2 -> isChoosed = true;
                    default -> System.out.println("Choose correct option");
                }
            }

    }

    private static void sortByCategory(ExpenseService service, Scanner sc) {
        ExpenseCategory category = chooseCategory(sc);
        var expByCat = service.getExpensesByCategory(category);
        for (var exp: expByCat){
            System.out.println(exp.toString());
        }
    }

    private static ExpenseCategory chooseCategory(Scanner sc){
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

    public static void showExpenses(ExpenseService service){
        for (Expense exp: service.getAllExpenses()){
            System.out.println(exp.toString());
        }
        System.out.println(service.getTotalAmount());
    }

}
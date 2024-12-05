package console;

import io.ExpenseReaderService;
import io.ExpenseWriterService;
import io.InputHandler;
import model.Expense;
import model.ExpenseCategory;
import repository.ExpenseRepository;
import services.ExpenseService;

public class ExpenseApp {
    private final InputHandler input;
    private  ExpenseService expenseService;

    public ExpenseApp(InputHandler input){
        this.input = input;
    }

    public void run(){
        switch (input.askToLoadExpenses()){
            case true -> expenseService = loadExpensesFromFile();
            case false -> expenseService = new ExpenseService(new ExpenseRepository());
        }

        while(true) {
            var option = input.getMenuOption();

            switch (option){
                case 1 -> showExpenses(expenseService);
                case 2 -> sortByCategory(expenseService);
                case 3 -> expenseService.addExpense(input);
                case 4 -> System.out.println("Total amount is " + expenseService.getTotalAmount());
                case 5 -> saveExpenses(expenseService);
                case 0 -> {
                    saveExpenses(expenseService);
                    return;
                }
            }
        }
    }

    private void saveExpenses(ExpenseService expenseService) {
        boolean isAnswerChecked = false;
        while(!isAnswerChecked){
            System.out.print("""
                    Save expenses to file?
                    1. Yes
                    2. No
                    """);

            var option = input.askToSaveExpenses();
            switch (option){
                case true -> {
                    ExpenseWriterService.writeExpensesToFile(expenseService.getAllExpenses());
                    isAnswerChecked = true;
                }
                case false -> isAnswerChecked = true;
            }
        }
    }

    private ExpenseService loadExpensesFromFile(){
        ExpenseRepository expenseRepository = new ExpenseRepository(ExpenseReaderService.readExpenses());
        return new ExpenseService(expenseRepository);
    }

    private void sortByCategory(ExpenseService service) {
        ExpenseCategory category = input.getValidCategory();
        var expByCat = service.getExpensesByCategory(category);
        if (!expByCat.isEmpty())
            for (var exp: expByCat){
                System.out.println(exp.toString());
            }
        else System.out.println("There is no expenses in this category.");
    }

    private void showExpenses(ExpenseService service) {
        var expenses = service.getAllExpenses();
        if (!expenses.isEmpty()) {
            for (Expense exp : expenses) {
                System.out.println(exp.toString());
            }
            System.out.println(service.getTotalAmount());
        }else System.out.println("There is no expenses.");
    }

}

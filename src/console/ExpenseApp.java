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
                case 1 -> showExpenses();
                case 2 -> sortByCategory();
                case 3 -> expenseService.addExpense(input);
                case 4 -> System.out.println("Total amount is " + expenseService.getTotalAmount());
                case 5 -> saveExpenses();
                case 0 -> {
                    saveExpenses();
                    return;
                }
            }
        }
    }

    private void saveExpenses() {
        var option = input.askToSaveExpenses();
        if (option) ExpenseWriterService.writeExpensesToFile(expenseService.getAllExpenses());
    }

    private ExpenseService loadExpensesFromFile(){
        ExpenseRepository expenseRepository = new ExpenseRepository(ExpenseReaderService.readExpenses());
        return new ExpenseService(expenseRepository);
    }

    private void sortByCategory() {
        ExpenseCategory category = input.getValidCategory();
        var expByCat = expenseService.getExpensesByCategory(category);
        if (!expByCat.isEmpty())
            for (var exp: expByCat){
                System.out.println(exp.toString());
            }
        else System.out.println("There is no expenses in this category.");
    }

    private void showExpenses() {
        var expenses = expenseService.getAllExpenses();
        if (!expenses.isEmpty()) {
            for (Expense exp : expenses) {
                System.out.println(exp.toString());
            }
            System.out.println(expenseService.getTotalAmount());
        }else System.out.println("There is no expenses.");
    }

}

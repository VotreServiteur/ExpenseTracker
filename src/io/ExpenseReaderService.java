package io;

import model.Expense;
import model.ExpenseCategory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExpenseReaderService {
    private static final File EXPENSES_STORAGE = new File("./src/storage/expenses");
    public static List<Expense> readExpenses(){
        List<Expense> expensesFromFile = new ArrayList<>();
        if (!EXPENSES_STORAGE.exists()){
            return expensesFromFile;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(EXPENSES_STORAGE))){
            String line;
            String[] expense;
            while((line = br.readLine()) != null){
                expense = line.split(" ");
                double amount = Double.parseDouble(expense[0]);
                ExpenseCategory category = ExpenseCategory.getExpenseByName(expense[1]);
                String description = expense[2];
                expensesFromFile.add(new Expense(amount, category, description));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return expensesFromFile;
    }
}

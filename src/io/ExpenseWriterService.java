package io;

import model.Expense;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExpenseWriterService {
    private static final File EXPENSES_STORAGE = new File("./src/storage/expenses");
    public static void writeExpensesToFile(List<Expense> expenses){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(EXPENSES_STORAGE))) {
            for(Expense exp: expenses){
                bw.write(exp.toString() + "\n");
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package repository;

import model.Expense;
import model.ExpenseCategory;

import java.util.List;

public interface ExpenseRepositoryInterface {
    void save(Expense expense);
    List<Expense> findAll();
    List<Expense> findByCategory(ExpenseCategory category);
}

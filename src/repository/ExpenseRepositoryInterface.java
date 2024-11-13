package repository;

import model.Expense;

import java.util.List;

public interface ExpenseRepositoryInterface {
    void save(Expense expense);
    List<Expense> findAll();
    List<Expense> findByCategory();
}

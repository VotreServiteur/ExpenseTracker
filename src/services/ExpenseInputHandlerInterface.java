package services;

import model.ExpenseCategory;

public interface ExpenseInputHandlerInterface {
    double getValidAmount();
    String getValidDescription();
    ExpenseCategory getValidCategory();
}

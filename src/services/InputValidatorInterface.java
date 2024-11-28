package services;

import model.ExpenseCategory;

public interface InputValidatorInterface {
    double getValidAmount();
    String getValidDescription();
    ExpenseCategory getValidCategory();
}

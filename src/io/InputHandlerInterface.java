package io;

import model.Expense;
import model.ExpenseCategory;

public interface InputHandlerInterface {

    boolean askToLoadExpenses();

    int getMenuOption();

    boolean askToSaveExpenses();

    int askOptionToRewrite();

    int necessaryToRewriteOption();

    double getValidAmount();

    String getValidDescription();

    ExpenseCategory getValidCategory();

    int askAboutValidity(Expense expense);



}

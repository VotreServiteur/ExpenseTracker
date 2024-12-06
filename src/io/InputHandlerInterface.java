package io;

import model.Expense;
import model.ExpenseCategory;

public interface InputHandlerInterface {

    boolean askToLoadExpenses();

    int getMenuOption();

    boolean askToSaveExpenses();

    int askOptionToRewrite(Expense expense);

    boolean askIfNecessaryToRewrite();

    double getValidAmount();

    String getValidDescription();

    ExpenseCategory getValidCategory();

    int askAboutValidity(Expense expense);

    boolean yesOrNoQuestion(String question);

    int chooseOptionQuestion(String question, int min, int max);
}

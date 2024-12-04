package model;

import java.util.Arrays;

public enum ExpenseCategory {
    FOOD("food"),
    TRANSPORT("transport"),
    HEALTH("health"),
    HOME("home");
    private String nameOfCategory;

    ExpenseCategory(String nameOfCategory) {
        setNameOfCategory(nameOfCategory.toUpperCase());
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public static ExpenseCategory getExpenseByName(String nameOfCategory){
        return Arrays.stream(ExpenseCategory.values())
                .filter(category -> category.getNameOfCategory().equalsIgnoreCase(nameOfCategory))
                .findFirst().
                orElseThrow(() -> new IllegalArgumentException("No enum constant with name: " + nameOfCategory));
    }
}

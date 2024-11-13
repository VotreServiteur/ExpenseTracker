package model;

public enum ExpenseCategory {
    FOOD("Food"),
    TRANSPORT("Transport"),
    HEALTH("Health"),
    HOME("Home");
    private String nameOfCategory;

    ExpenseCategory(String nameOfCategory) {
        setNameOfCategory(nameOfCategory);
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }
}

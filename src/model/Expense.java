package model;

public class Expense {
    private double amount;
    private ExpenseCategory category;
    private String description;

    public Expense(double valueOfExpense, ExpenseCategory category, String description){
        setAmount(valueOfExpense);
        setCategory(category);
        setDescription(description);
    }

    @Override
    public String toString(){
        return getAmount() + " " + getCategory().getNameOfCategory() + " " + getDescription();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

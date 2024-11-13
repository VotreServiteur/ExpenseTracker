package model;

public class Expense {
    private double amount;
    private ExpenseCategory category;

    public Expense(double valueOfExpense, ExpenseCategory category){
        setAmount(valueOfExpense);
        setCategory(category);
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
}

import console.ExpenseApp;
import io.InputHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InputHandler input = new InputHandler(sc);

        ExpenseApp app = new ExpenseApp(input);
        app.run();
    }
}
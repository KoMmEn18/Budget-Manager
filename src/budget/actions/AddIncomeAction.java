package budget.actions;

import budget.Database;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddIncomeAction implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("Enter income:");
        boolean incomeValid = false;
        while (!incomeValid) {
            try {
                double income = Double.parseDouble(scanner.nextLine());
                database.addBalance(income);
                incomeValid = true;
                System.out.println("Income was added!");
            } catch (IllegalArgumentException exception) {
                System.out.println("That's not a valid income. Try again.");
            }
        }
    }

    @Override
    public String getName() {
        return "Add income";
    }
}

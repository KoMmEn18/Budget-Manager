package budget.actions;

import budget.Database;

import java.util.Scanner;

public class UnknownAction implements Action {

    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("Undefined action");
    }

    @Override
    public String getName() {
        return "Unknown";
    }
}

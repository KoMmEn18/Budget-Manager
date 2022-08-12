package budget.actions;

import budget.Database;

import java.util.Scanner;

public class ShowBalanceAction implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.printf("Balance: $%.2f %n", database.getBalance());
    }

    @Override
    public String getName() {
        return "Balance";
    }
}

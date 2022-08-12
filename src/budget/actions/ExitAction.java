package budget.actions;

import budget.Database;

import java.util.Scanner;

public class ExitAction implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        System.out.println("Bye!");
        System.exit(1);
    }

    @Override
    public String getName() {
        return "Exit";
    }
}

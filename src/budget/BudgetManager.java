package budget;

import budget.actions.Action;
import budget.actions.ActionManager;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BudgetManager {

    private final ActionManager actionManager = new ActionManager();
    private final Scanner scanner = new Scanner(System.in);
    private final Database database = new Database();
    public void run() {
        processUserAction();
    }

    private void processUserAction() {
        while (true) {
            printActionMenu();
            int actionNumber = -1;
            try {
                actionNumber = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignore) {}

            System.out.println();
            actionManager.setAction(actionNumber);
            actionManager.execute(scanner, database);
            System.out.println();
        }
    }

    private void printActionMenu() {
        System.out.println("Choose your action:");
        for (var entry : Action.actions.entrySet()) {
            System.out.println(entry.getKey() + ") " + entry.getValue().getName());
        }
    }
}

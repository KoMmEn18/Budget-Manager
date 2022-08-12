package budget.actions;

import budget.Database;

import java.util.Scanner;

public class ActionManager {
    private Action action;

    public void setAction(int action) {
        this.action = Action.actions.getOrDefault(action, new UnknownAction());
    }

    public void execute(Scanner scanner, Database database) {
        this.action.execute(scanner, database);
    }
}

package budget.actions;

import budget.Database;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public interface Action {
    Map<Integer, Action> actions = getActions();

    public void execute(Scanner scanner, Database database);

    public String getName();

    private static Map<Integer, Action> getActions() {
        var map = new LinkedHashMap<Integer, Action>();
        map.put(1, new AddIncomeAction());
        map.put(2, new AddPurchaseAction());
        map.put(3, new ShowPurchasesAction());
        map.put(4, new ShowBalanceAction());
        map.put(5, new SaveAction());
        map.put(6, new LoadAction());
        map.put(7, new AnalyzeAction());
        map.put(0, new ExitAction());

        return Collections.unmodifiableMap(map);
    }
}

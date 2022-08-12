package budget.actions;

import budget.Category;
import budget.Database;
import budget.analyzer.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AnalyzeAction implements Action {

    private final PurchaseAnalyzerManager analyzerManager = new PurchaseAnalyzerManager();

    @Override
    public void execute(Scanner scanner, Database database) {
        boolean proceedSort = true;
        while (proceedSort) {
            printSortMenu();
            boolean inputValid = false;
            while (!inputValid) {
                try {
                    int sortType = Integer.parseInt(scanner.nextLine());
                    if (sortType == 4) {
                        proceedSort = false;
                        break;
                    }
                    PurchaseAnalyzer analyzer = create(sortType, database, scanner);
                    analyzerManager.setAnalyzer(analyzer);
                    System.out.println();
                    analyzerManager.sortPurchases(database.getPurchases());
                    System.out.println();
                    inputValid = true;
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Analyze (Sort)";
    }

    public PurchaseAnalyzer create(int sortType, Database database, Scanner scanner) {
        switch (sortType) {
            case 1: {
                return new SortAll();
            }
            case 2: {
                return new SortByType(database.getCategories());
            }
            case 3: {
                return new SortCertainType(getSortCategory(scanner, database));
            }
            default: {
                throw new IllegalArgumentException("Unknown sort type " + sortType);
            }
        }
    }

    private Category getSortCategory(Scanner scanner, Database database) {
        System.out.println();
        System.out.println("Choose the type of purchase");
        ArrayList<Category> categories = database.getCategories();
        int iterator = 1;
        for (Category category : categories) {
            System.out.println(iterator++ + ") " + category.getName());
        }

        while (true) {
            int chosenCategory = -1;
            try {
                chosenCategory = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignore) {}

            if (chosenCategory >= 1 && chosenCategory <= categories.size()) {
                return categories.get(chosenCategory - 1);
            }

            System.out.println("You have not provided valid number. Try again!");
        }
    }

    private void printSortMenu() {
        System.out.print("""
        How do you want to sort?
        1) Sort all purchases
        2) Sort by type
        3) Sort certain type
        4) Back
        """);
    }
}

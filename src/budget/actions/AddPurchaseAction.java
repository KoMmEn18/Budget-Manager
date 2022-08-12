package budget.actions;

import budget.Category;
import budget.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class AddPurchaseAction implements Action {
    @Override
    public void execute(Scanner scanner, Database database) {
        while (true) {
            System.out.println("Choose the type of purchase");
            Category category = getPurchaseCategory(scanner, database);

            if (category == null) {
                return;
            }

            boolean purchaseValid = false;
            while (!purchaseValid) {
                try {
                    System.out.println();
                    System.out.println("Enter purchase name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter its price:");
                    double price = Double.parseDouble(scanner.nextLine());
                    database.addPurchase(name, price, category);
                    purchaseValid = true;
                    System.out.println("Purchase was added!");
                    System.out.println();
                } catch (IllegalArgumentException exception) {
                    System.out.println("You have not provided valid data. Try again.");
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Add purchase";
    }

    private Category getPurchaseCategory(Scanner scanner, Database database) {
        ArrayList<Category> categories = database.getCategories();
        int iterator = 1;
        for (Category category : categories) {
            System.out.println(iterator++ + ") " + category.getName());
        }
        System.out.println(iterator + ") Back");

        while (true) {
            int chosenCategory = -1;
            try {
                chosenCategory = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignore) {}

            if (chosenCategory == categories.size() + 1) {
                return null;
            }

            if (chosenCategory >= 1 && chosenCategory <= categories.size()) {
                return categories.get(chosenCategory - 1);
            }

            System.out.println("You have not provided valid number. Try again!");
        }
    }
}

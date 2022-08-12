package budget.actions;

import budget.Category;
import budget.Database;
import budget.Purchase;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;

public class ShowPurchasesAction implements Action {

    private LinkedHashSet<Purchase> allPurchases;
    @Override
    public void execute(Scanner scanner, Database database) {
        allPurchases = database.getPurchases();
        if (allPurchases.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            showPurchasesByCategory(scanner, database);
        }
    }

    @Override
    public String getName() {
        return "Show list of purchases";
    }

    private void showPurchasesByCategory(Scanner scanner, Database database) {
        while (true) {
            System.out.println("Choose the type of purchases");
            ArrayList<Category> categories = database.getCategories();
            int iterator = 1;
            for (Category category : categories) {
                System.out.println(iterator++ + ") " + category.getName());
            }
            System.out.println(iterator++ + ") All");
            System.out.println(iterator + ") Back");

            LinkedHashSet<Purchase> purchases = getPurchasesByCategory(scanner, categories);

            if (purchases == null) {
                return;
            }

            if (purchases.isEmpty()) {
                System.out.println("The purchase list is empty!");
            } else {
                double totalPrice = 0;
                for (Purchase purchase : purchases) {
                    System.out.println(purchase);
                    totalPrice += purchase.getPrice();
                }
                System.out.printf("Total sum: $%.2f %n", totalPrice);
            }
            System.out.println();
        }
    }

    private LinkedHashSet<Purchase> getPurchasesByCategory(Scanner scanner, ArrayList<Category> categories) {
        LinkedHashSet<Purchase> purchases = (LinkedHashSet<Purchase>) allPurchases.clone();
        boolean categoryValid = false;
        while (!categoryValid) {
            int chosenCategoryIndex = -1;
            try {
                chosenCategoryIndex = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignore) {}

            if (chosenCategoryIndex == categories.size() + 2) {
                return null;
            }

            System.out.println();

            if (chosenCategoryIndex == categories.size() + 1) {
                System.out.println("All:");
                return allPurchases;
            }

            if (!(chosenCategoryIndex >= 1 && chosenCategoryIndex <= categories.size())) {
                System.out.println("You have not provided valid number. Try again!");
                continue;
            }

            categoryValid = true;
            final Category chosenCategory = categories.get(chosenCategoryIndex - 1);
            System.out.println(chosenCategory.getName() + ":");
            purchases.removeIf(purchase -> !Objects.equals(purchase.getCategory(), chosenCategory));
        }

        return purchases;
    }
}

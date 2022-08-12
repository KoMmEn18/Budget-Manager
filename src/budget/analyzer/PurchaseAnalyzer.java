package budget.analyzer;

import budget.Purchase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public interface PurchaseAnalyzer {

    public default void printSortedPurchases(LinkedHashSet<Purchase> purchases, String type) {
        if (purchases.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            ArrayList<Purchase> sortedPurchases = new ArrayList<>(purchases);
            sortedPurchases.sort(Collections.reverseOrder());

            double totalPrice = 0;
            System.out.println(type + ":");
            for (Purchase purchase : sortedPurchases) {
                System.out.println(purchase);
                totalPrice += purchase.getPrice();
            }
            System.out.printf("Total sum: $%.2f %n", totalPrice);
        }
    }
    void analyze(LinkedHashSet<Purchase> purchases);
}

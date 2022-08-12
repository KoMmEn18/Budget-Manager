package budget.analyzer;

import budget.Category;
import budget.Purchase;

import java.util.*;

public class SortByType implements PurchaseAnalyzer {

    private HashMap<Category, Double> purchasesByCategory = new HashMap<>();
    public SortByType(ArrayList<Category> categories) {
        categories.forEach(category -> purchasesByCategory.put(category, 0.0));
    }
    @Override
    public void analyze(LinkedHashSet<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            Category category = purchase.getCategory();
            purchasesByCategory.put(category, purchasesByCategory.get(category) + purchase.getPrice());
        }

        purchasesByCategory.entrySet()
                .stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.printf("%s - $%.2f%n", k.getKey().getName(), k.getValue()));
    }
}

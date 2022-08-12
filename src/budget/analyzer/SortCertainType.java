package budget.analyzer;

import budget.Category;
import budget.Purchase;

import java.util.LinkedHashSet;
import java.util.Objects;

public class SortCertainType implements PurchaseAnalyzer {

    private Category category;
    public SortCertainType(Category category) {
        this.category = category;
    }
    @Override
    public void analyze(LinkedHashSet<Purchase> purchases) {
        purchases.removeIf(purchase -> !Objects.equals(purchase.getCategory(), category));
        printSortedPurchases(purchases, category.getName());
    }
}

package budget.analyzer;

import budget.Purchase;

import java.util.LinkedHashSet;

public class SortAll implements PurchaseAnalyzer {
    @Override
    public void analyze(LinkedHashSet<Purchase> purchases) {
        printSortedPurchases(purchases, "All");
    }
}

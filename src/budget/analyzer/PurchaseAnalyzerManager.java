package budget.analyzer;

import budget.Purchase;

import java.util.LinkedHashSet;

public class PurchaseAnalyzerManager {
    private PurchaseAnalyzer analyzer;

    public void setAnalyzer(PurchaseAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void sortPurchases(LinkedHashSet<Purchase> purchases) {
        this.analyzer.analyze(purchases);
    }
}

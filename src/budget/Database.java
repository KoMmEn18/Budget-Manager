package budget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Database {
    private double balance = 0;
    private LinkedHashSet<Purchase> purchases = new LinkedHashSet<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public Database() {
        setCategories();
    }

    public void addBalance(double balance) {;
        if (balance < 0) {
            throw new IllegalArgumentException();
        }

        this.balance += balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addPurchase(String name, double price, Category category) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }

        purchases.add(new Purchase(name, price, category));
        balance = balance - price > 0 ? balance - price : 0;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void addPurchaseWithoutBalance(String name, double price, Category category) {

    }

    public LinkedHashSet<Purchase> getPurchases() {
        return (LinkedHashSet<Purchase>) purchases.clone();
    }

    public ArrayList<Category> getCategories() {
        return (ArrayList<Category>) categories.clone();
    }

    private void setCategories() {
        categories.addAll(Arrays.asList(
                new Category("Food"),
                new Category("Clothes"),
                new Category("Entertainment"),
                new Category("Other")));
    }
}

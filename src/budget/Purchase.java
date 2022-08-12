package budget;

import java.io.Serializable;
import java.util.Objects;

public class Purchase implements Serializable, Comparable<Purchase> {
    private String name;
    private double price;
    private Category category;

    public Purchase(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Purchase purchase = (Purchase) o;

        return Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        return 31 * result;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", name, price);
    }

    @Override
    public int compareTo(Purchase o) {
        return Double.compare(price, o.price);
    }
}

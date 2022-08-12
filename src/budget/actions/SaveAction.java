package budget.actions;

import budget.Database;
import budget.Purchase;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SaveAction extends FileAction {

    @Override
    public void execute(Scanner scanner, Database database) {
        File file = new File(fullPathname);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(database.getBalance());
            LinkedHashSet<Purchase> purchases = database.getPurchases();
            for (Purchase purchase : purchases) {
                outputStream.writeObject(purchase);
            }
            outputStream.writeObject(null);
            System.out.println("Purchases were saved!");
        } catch (IOException ex) {
            System.out.printf("An exception occurred %s", ex.getMessage());
        }
    }

    @Override
    public String getName() {
        return "Save";
    }
}

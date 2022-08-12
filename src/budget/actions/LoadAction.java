package budget.actions;

import budget.Category;
import budget.Database;
import budget.Purchase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LoadAction extends FileAction {

    @Override
    public void execute(Scanner scanner, Database database) {
        File file = new File(fullPathname);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            double balance = (double) inputStream.readObject();
            database.addBalance(balance);
            Purchase purchase;
            while ((purchase = (Purchase) inputStream.readObject()) != null) {
                database.addPurchase(purchase);
            }
            System.out.println("Purchases were loaded!");
        } catch (IOException ex) {
            System.out.printf("An exception occurred %s", ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Data in file was not valid to read");
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        }
    }

    @Override
    public String getName() {
        return "Load";
    }
}

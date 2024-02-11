import Store.FileStore;
import Store.IStore;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import Exception.*;

public class PasswordManager {
    public static void main(String[] args) {
        IStore store = new FileStore();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter command (create password, get password or delete password):");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.contains("create password")) {
                System.out.println("Enter email:");
                String email = scanner.nextLine();

                System.out.println("Enter username:");
                String username = scanner.nextLine();

                System.out.println("Enter password:");
                String password = scanner.nextLine();

                store.save(email, username, password);
            } else if (userInput.contains("get password")) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();

                String password = store.getPassword(username);
                System.out.println("Password: " + password);
            } else if (userInput.contains("delete password")) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();

                store.delete(username);
            } else {
                System.out.println("Invalid command");
            }
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

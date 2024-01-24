import Store.FileStore;
import Store.IStore;

import java.util.Scanner;
import java.io.FileWriter;

public class PasswordManager {
    public static void main(String[] args) {
        //TODO: ASK Website name
        //TODO: ASK LOGIN
        //TODO: ASK Password
        // Use FileWriter lib to save to file
        // Ask user for an action
        // If create password - ask for email, user, password and then save to file
        // If get password - output file
        // If delete password - delete info from file
        IStore store = new FileStore();

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

            String password = store.get(username);
            System.out.println("Password: " + password);
        } else if (userInput.contains("delete password")) {
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            store.delete(username);
            System.out.println("Password deleted successfully.");
        } else {
            System.out.println("Invalid command.");
        }
        scanner.close();

    }
}

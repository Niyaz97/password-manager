package Store;

import java.util.Scanner;

public class FileStore implements IStore {

    @Override
    public void save() {
        Scanner getInput = new Scanner(System.in);

        System.out.println("Enter something:");
        String userInput = getInput.nextLine();

        System.out.println(userInput);
        getInput.close();

        System.out.println("Saved");
    }

    @Override
    public void get() {

        Scanner getInput = new Scanner(System.in);

        System.out.println("Enter something:");
        String userInput = getInput.nextLine();

        System.out.println(userInput);
        getInput.close();

        System.out.println("Got");
    }

    @Override
    public void delete() {
        Scanner getInput = new Scanner(System.in);

        System.out.println("Enter something:");
        String userInput = getInput.nextLine();

        System.out.println(userInput);
        getInput.close();

        System.out.println("Deleted");
    }
}

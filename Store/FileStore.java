package Store;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class FileStore implements IStore {

    @Override
    public void save(String email, String username, String password) {
        try (FileWriter fileWriter = new FileWriter("passwords.txt", true)) {
            fileWriter.write(email + ";" + username + ";" + password + ";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get(String username) {
        String password = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && (parts[1].equals(username))) {
                    password = parts[2];
                    break;
                }
            }
            if (password != null) {
                System.out.println("Password for user " + username + " found");
            } else {
                System.out.println("User " + username + " not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return password;
    }

    @Override
    public void delete(String username) {
        Path path = Paths.get("passwords.txt");
        List<String> fileContent = new ArrayList<>();
        boolean isDeleted = false;

        try {
            fileContent = new ArrayList<>(Files.readAllLines(path));
            Iterator<String> iterator = fileContent.iterator();

            while (iterator.hasNext()) {
                String line = iterator.next();
                String[] parts = line.split(";");
                if (parts[1].equals(username)) {
                    iterator.remove();
                    isDeleted = true;
                    break;
                }
            }
            System.out.println(fileContent);
            if (isDeleted) {
                Files.write(path, fileContent);
                System.out.println("User " + username + " deleted");
            } else {
                System.out.println("User " + username + " not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package Store;

import java.util.Scanner;
import java.io.*;

public class FileStore implements IStore {

    @Override
    public void save(String email, String username, String password) {
        try (FileWriter fileWriter = new FileWriter("passwords.txt", true)) {
            fileWriter.write("Email: " + email + "\n");
            fileWriter.write("Username: " + username + "\n");
            fileWriter.write("Password: " + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String get(String username) {

        try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Username: " + username)) {
                    line = reader.readLine();
                    return line.substring(line.indexOf(":") + 2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Username not found";
    }

    @Override
    public void delete(String username) {
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("Username: " + username)) {
                    writer.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original file
        if (!tempFile.renameTo(new File("passwords.txt"))) {
            System.out.println("Error deleting password.");
        }

    }
}

package Store;

import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import Exception.*;

public class FileStore implements IStore {

    @Override
    public void save(String email, String username, String password) {
        try (FileWriter fileWriter = new FileWriter("passwords.txt", true)) {
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            fileWriter.write(email + ";" + username + ";" + encodedPassword + ";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPassword(String username) throws PasswordNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("passwords.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && (parts[1].equals(username))) {
                    byte[] decodedPassword = Base64.getDecoder().decode(parts[2]);
                    return new String(decodedPassword, StandardCharsets.UTF_8);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new PasswordNotFoundException("Password not found");
    }

    @Override
    public void delete(String username) throws UserNotFoundException {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException("User " + username + " not found");
    }
}

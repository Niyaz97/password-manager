import Store.FileStore;
import Store.IStore;

import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        //TODO: ASK Website name
        //TODO: ASK LOGIN
        //TODO: ASK Password

        IStore store = new FileStore();
        store.get();
    }
}

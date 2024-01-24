package Store;

public class DBStore implements IStore {

    @Override
    public void save(String email, String username, String password) {

    }

    @Override
    public String get(String username) {

        return username;
    }

    @Override
    public void delete(String username) {

    }
}

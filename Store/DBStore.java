package Store;

public class DBStore implements IStore {

    @Override
    public void save(String email, String username, String password) {

    }

    @Override
    public String getPassword(String username) {

        return username;
    }

    @Override
    public void delete(String username) {

    }
}

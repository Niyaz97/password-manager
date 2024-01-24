package Store;

public interface IStore {
    public void save(String email, String username, String password);
    public String get(String username);

    public void delete(String username);
}

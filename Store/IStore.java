package Store;

public interface IStore {
    public void save(String email, String username, String password);
    public String getPassword(String username) throws Exception;

    public void delete(String username) throws Exception;
}

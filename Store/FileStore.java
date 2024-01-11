package Store;

public class FileStore implements IStore {

    @Override
    public void save() {
        System.out.println("Saved");
    }

    @Override
    public void get() {
        System.out.println("Got");
    }

    @Override
    public void delete() {
        System.out.println("Deleted");
    }
}

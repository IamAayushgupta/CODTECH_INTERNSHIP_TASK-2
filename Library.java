package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<User> users;

    public Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
        loadData();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        saveData();
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
        saveData();
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByCategory(String category) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public void addUser(User user) {
        users.add(user);
        saveData();
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                return user;
            }
        }
        return null;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    private void saveData() {
        // Implement file saving logic here
    }

    private void loadData() {
        // Add some dummy data for testing
        users.add(new Librarian("admin", "password"));
        users.add(new Patron("patron", "password"));

        items.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        items.add(new Magazine("Time", "Time Inc.", "News"));
        items.add(new DVD("Inception", "Christopher Nolan", "Movies"));
    }
}

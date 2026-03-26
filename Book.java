import java.util.ArrayList;
import java.util.List;

public class Book implements BookInterface{
    private String title;
    private boolean isAvailable;
    private List<BookObserver> observers;

    public Book(String title) {
        this.title = title;
        this.isAvailable = true;
        this.observers = new ArrayList<>();
    }

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (BookObserver observer : observers) {
            observer.update(title);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void borrowBook(User user) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(user.getName() + " borrowed: " + title);
        } else {
            System.out.println(title + " is not available.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
        notifyObservers(); 
    }
}

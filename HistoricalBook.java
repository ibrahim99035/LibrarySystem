public class HistoricalBook extends Book {
    public HistoricalBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        if (!isAvailable()) {
            System.out.println(getTitle() + " is not available.");
            return;
        }
        System.out.println("Historical book '" + getTitle() + "' borrowed by " + user.getName());
        super.borrowBook(user);
    }
}
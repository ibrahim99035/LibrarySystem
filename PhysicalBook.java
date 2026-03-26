public class PhysicalBook extends Book {
    public PhysicalBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        if (!isAvailable()) {
            System.out.println(getTitle() + " is not available.");
            return;
        }
        System.out.println("Physical book '" + getTitle() + "' borrowed by " + user.getName());
        super.borrowBook(user);
    }
}
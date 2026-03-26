public class EBook extends Book {
    public EBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        // Requirement 4: premium access guard
        if (!user.isPremium()) {
            System.out.println("Sorry " + user.getName() + ", EBooks are for premium users only.");
            return;
        }
        System.out.println("E-book '" + getTitle() + "' borrowed by " + user.getName());
        super.borrowBook(user);
    }
}
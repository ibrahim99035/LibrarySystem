public class PremiumBookDecorator extends Book {
    private Book wrappedBook;

    public PremiumBookDecorator(Book book) {
        super(book.getTitle());
        this.wrappedBook = book;
    }

    @Override
    public void borrowBook(User user) {
        wrappedBook.borrowBook(user);
        System.out.println("  [Premium] Extra 10 days granted for '" + getTitle() + "'");
    }

    @Override
    public void returnBook() {
        wrappedBook.returnBook();
    }

    @Override
    public boolean isAvailable() {
        return wrappedBook.isAvailable();
    }
}
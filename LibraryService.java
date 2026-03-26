import java.util.ArrayList;
import java.util.List;

public class LibraryService{
    private static LibraryService instance;

    private List<Book> books = new ArrayList<>();

    private BorrowHandler borrowChain;

    private LibraryService(){
        BorrowHandler librarian = new LibrarianHandler();
        BorrowHandler manager  = new ManagerHandler();
        BorrowHandler director = new DirectorHandler();
        librarian.setNext(manager).setNext(director);
        this.borrowChain = librarian;
    }

    public static LibraryService getInstance(){
        if(instance == null){
            instance = new LibraryService();
        }
        return instance;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public Book findBook(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    public void requestBorrow(String title, User user, int days){
        Book book = findBook(title);
        if(book == null){
            System.out.println("Book '" + title + "' not found.");
            return;
        }
        borrowChain.handleRequest(user, book, days);
    }

    public void returnBook(String title){
        Book book = findBook(title);
        if(book != null){
            book.returnBook();
        }else{
            System.out.println("Book '" + title + "' not found.");
        }
    }

    public void addExternalBook(ExternalBookData externalData){
        Book adapted = BookAdapter.adapt(externalData);
        if(adapted != null){
            books.add(adapted);
        }
    }
}
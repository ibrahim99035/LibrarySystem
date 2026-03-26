public class DirectorHandler extends BorrowHandler{
    @Override
    public void handleRequest(User user, Book book, int days){
        if(days >= 15){
            System.out.println("Director approved: '" + book.getTitle() + "' for " + user.getName() + " (" + days + " days)");
            
            book.borrowBook(user);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(user, book, days);
        } else {
            System.out.println("Request denied.");
        }
    }
}
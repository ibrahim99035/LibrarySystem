public class ManagerHandler extends BorrowHandler{
    @Override
    public void handleRequest(User user, Book book, int days) {
        if(days <= 14){
            System.out.println("Manager approved: '" + book.getTitle() + "' for " + user.getName() + " (" + days + " days)");
            
            book.borrowBook(user);
        } else if (nextHandler != null) {
            System.out.println("Manager: " + days + " days exceeds my limit, escalating...");
            nextHandler.handleRequest(user, book, days);
        } else {
            System.out.println("Request denied: no handler available.");
        }
    }
}
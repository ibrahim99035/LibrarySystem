public abstract class BorrowHandler{
    protected BorrowHandler nextHandler;

    public BorrowHandler setNext(BorrowHandler next){
        this.nextHandler = next;
        return next;
    }

    public abstract void handleRequest(User user, Book book, int days);
}
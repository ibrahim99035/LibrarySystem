public class BookAdapter{
    public static Book adapt(ExternalBookData externalData){
        if(!externalData.isBorrowable()){
            System.out.println("Book '" + externalData.getBookTitle() + "' is not borrowable, skipping.");
            return null;
        }

        Book book = new Book(externalData.getBookTitle());
        
        System.out.println("Adapted external book: '" + externalData.getBookTitle()+ "' by " + externalData.getAuthorName()+ " (" + externalData.getYear() + ")");
               
        return book;
    }
}
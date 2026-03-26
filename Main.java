public class Main{
    public static void main(String[] args){

        LibraryService library = LibraryService.getInstance();

        library.addBook(BookFactory.createBook("physical",   "Harry Potter"));
        library.addBook(BookFactory.createBook("ebook",      "Clean Code"));
        library.addBook(BookFactory.createBook("historical", "Sapiens"));
        library.addBook(BookFactory.createBook("premium",    "Design Patterns"));

        library.addExternalBook(new ExternalBookData("Refactoring", true, "Martin Fowler", 1999));

        User john    = new User("John", false); 
        User sarah   = new User("Sarah", true);  

        Book harry = library.findBook("Harry Potter");
        if (harry != null) harry.addObserver(john);

        System.out.println("\nBorrow requests");

        library.requestBorrow("Harry Potter",    john,  5);   
        library.requestBorrow("Sapiens",         sarah, 10);  
        library.requestBorrow("Design Patterns", sarah, 20); 

        System.out.println("\nEBook access");
        library.requestBorrow("Clean Code", john,  3); 
        library.requestBorrow("Clean Code", sarah, 3);

        System.out.println("\nReturning Harry Potter");
        library.returnBook("Harry Potter"); 
    }
}
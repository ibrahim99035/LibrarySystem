public class BookFactory {
    public static Book createBook(String type, String title){
        switch(type.toLowerCase()){
            case "physical":
                return new PhysicalBook(title);
            case "ebook":
                return new EBook(title);
            case "historical":
                return new HistoricalBook(title);
            case "premium":
                return new PremiumBookDecorator(new PhysicalBook(title));
            default:
                System.out.println("Unknown type '" + type + "', creating base Book.");
                return new Book(title);
        }
    }
}
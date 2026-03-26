public class User implements BookObserver {
    private String name;
    private boolean isPremium;

    public User(String name) {
        this.name = name;
    }


    public User(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setIsPremium(boolean isPremium){
        this.isPremium = isPremium;
    }
    public boolean isPremium() {
        return isPremium;
    }

    @Override
    public void update(String bookTitle) {
        System.out.println(name + " has been notified that " + bookTitle + " is now available.");
    }
    
}

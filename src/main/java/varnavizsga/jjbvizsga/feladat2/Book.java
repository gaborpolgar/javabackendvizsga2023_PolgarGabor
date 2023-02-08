package varnavizsga.jjbvizsga.feladat2;

public class Book {

    private int id;
    private String author;
    private String title;
    private int price;
    private boolean onSale;

    private static int ACTION_RATE = 15;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public Book(int id, String author, String title, int price, boolean onSale) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.onSale = onSale;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getCurrentPrice() {
        return onSale? (int) Math.ceil((price* 0.85)):getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %d Ft", author, title, getCurrentPrice());

    }
}

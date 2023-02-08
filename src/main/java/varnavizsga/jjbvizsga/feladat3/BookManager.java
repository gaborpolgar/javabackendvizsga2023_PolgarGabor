package varnavizsga.jjbvizsga.feladat3;

import varnavizsga.jjbvizsga.feladat2.Book;

import java.util.ArrayList;

public class BookManager {

    private ArrayList<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(int id, String author, String title, int price, boolean onSale) {
     Book book = new Book(id, author, title, price, onSale);
     books.add(book);
    }
    public int getBookCount() {
        return books.size();
    }
    public long getTotalPrice() {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }

    public int countOnSale() {
        int count = 0;
        for (Book book : books) {
            if (book.isOnSale())
                count++;
        }
        return count;
    }
}

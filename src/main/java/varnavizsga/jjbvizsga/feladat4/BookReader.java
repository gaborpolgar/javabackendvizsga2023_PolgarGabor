package varnavizsga.jjbvizsga.feladat4;

import varnavizsga.jjbvizsga.feladat2.Book;

import javax.xml.stream.util.StreamReaderDelegate;
import java.io.Console;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookReader {

    ArrayList<Book> books;

    public void readBooksFromFile(String fileName) {
        books = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scanner = new Scanner(fr);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String temp = scanner.nextLine();
                String temps [] = temp.split(";");
                System.out.println(temp);
                System.out.println(temps[3]);
                Book book = new Book(Integer.parseInt(temps[0]), temps[1], temps[2], Integer.parseInt(temps[3]), temps[4].equals("0")? false:true);
                books.add(book);
            }
        } catch (Exception e){
            System.err.println("");
        }
    }

    public int countOnSale() {
        int count = 0;
        for (Book book : books) {
            if (book.isOnSale())
                count++;
        }
        return count;
    }

    public String getCheapest() {
        Book CheapestBook = books.get(0);
        System.out.println(CheapestBook);
        for (Book book : books) {
            System.out.println(book.getPrice());
            System.out.println(CheapestBook.getPrice());
            if (book.getPrice() < CheapestBook.getPrice()){
                CheapestBook = book;
            }
        }
        return CheapestBook.getTitle();
    }
}

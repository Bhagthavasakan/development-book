package src.main.java.bookstore;
import java.util.ArrayList;
import java.util.List;


public class Basket {
    private final List<String> books;

    public Basket(List<String> books) {
        this.books = new ArrayList<>(books);
    }

    public List<String> getBooks() {
        return books;
    }
}


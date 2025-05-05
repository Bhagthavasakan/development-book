package src.main.java.bookstore;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class PriceCalculator {

    private static final double BOOK_PRICE = 50.0;

    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 0.0,
            2, 0.05,
            3, 0.10,
            4, 0.20,
            5, 0.25
    );

    public static double calculateTotal(Basket basket) {
        List<String> books = new ArrayList<>(basket.getBooks());
        double total = 0.0;

        while (!books.isEmpty()) {
            // Create a set of unique book titles (distinct)
            Set<String> uniqueSet = new HashSet<>(books);
            int setSize = uniqueSet.size();

            // Group of distinct books for this discount round
            List<String> group = new ArrayList<>(uniqueSet);

            // Remove one instance of each book in this group from books list
            for (String book : group) {
                books.remove(book);
            }

            double discount = DISCOUNTS.getOrDefault(setSize, 0.0);
            total += setSize * BOOK_PRICE * (1 - discount);
        }

        return total;
    }
}

package src.main.java.bookstore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> books = List.of(
                "CLEAN_CODE", "CLEAN_CODE",
                "CLEAN_CODER", "CLEAN_CODER",
                "CLEAN_ARCHITECTURE", "CLEAN_ARCHITECTURE",
                "TDD", "LEGACY_CODE"
        );

        Basket basket = new Basket(books);
        double total = PriceCalculator.calculateTotal(basket);

        System.out.println("Total price: " + total); // Should print 320.0
    }
}


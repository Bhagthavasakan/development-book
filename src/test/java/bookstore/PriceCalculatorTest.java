package src.test.java.bookstore;

import org.junit.jupiter.api.Test;
import src.main.java.bookstore.Basket;
import src.main.java.bookstore.PriceCalculator;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    @Test
    public void testSingleBook() {
        List<String> books = List.of("CLEAN_CODE");
        Basket basket = new Basket(books);
        double total = PriceCalculator.calculateTotal(basket);
        assertEquals(50.0, total);
    }

    @Test
    public void testTwoDifferentBooks() {
        List<String> books = List.of("CLEAN_CODE", "CLEAN_CODER");
        Basket basket = new Basket(books);
        double total = PriceCalculator.calculateTotal(basket);
        assertEquals(95.0, total); // 5% discount on 2 books
    }

    @Test
    public void testThreeSameBooks() {
        List<String> books = List.of("CLEAN_CODE", "CLEAN_CODE", "CLEAN_CODE");
        Basket basket = new Basket(books);
        double total = PriceCalculator.calculateTotal(basket);
        assertEquals(150.0, total); // No discount, same book
    }

    @Test
    public void testComplexExampleWithDuplicates() {
        List<String> books = List.of(
                "CLEAN_CODE", "CLEAN_CODE",
                "CLEAN_CODER", "CLEAN_CODER",
                "CLEAN_ARCHITECTURE", "CLEAN_ARCHITECTURE",
                "TDD", "LEGACY_CODE"
        );
        Basket basket = new Basket(books);
        double total = PriceCalculator.calculateTotal(basket);
        assertEquals(322.5, total); // 2 groups of 4 with 20% discount
    }
}


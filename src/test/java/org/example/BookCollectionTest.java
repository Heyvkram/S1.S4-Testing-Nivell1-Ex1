package org.example;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookCollectionTest {
    BookCollection bookCollection = new BookCollection();
    Book firstBook = new Book("first book");
    Book secondBook = new Book("second Book");
    Book thirdBook = new Book("third book");
    Book duplicateThirdBook = new Book("third book");
    Book fourthBook = new Book("fourth book");
    Book aBook = new Book("A");
    Book bBook = new Book("B");
    Book dBook = new Book("D");

    @Test
    void testListIsNotNull() {
        assertNotNull(bookCollection.getCollection());
    }

    @Test
    void sizeCheckTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals(3, bookCollection.getCollection().size());
    }

    @Test
    void bookPositionCheckTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals("second Book", bookCollection.getBookByTittlePosition(1));
    }

   @Test
    void notDuplicateBookTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        bookCollection.addBook(duplicateThirdBook);
        assertFalse(bookCollection.duplicateChecker(bookCollection.getCollection()));
    }

    @Test
    void titlePositionTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals("second Book", bookCollection.getCollection().get(1).getTitle());
    }

    @Test
    void addBookTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        bookCollection.addBookByPosition(1, fourthBook);
        assertEquals(fourthBook, bookCollection.getCollection().get(1));
    }

    @Test
    void listReductionTest() {
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        bookCollection.addBookByPosition(1, fourthBook);
        bookCollection.deleteBookByTitle("fourth book");
        assertEquals(3, bookCollection.getCollection().size());
    }

    @Test
    void orderListTest(){
        bookCollection.addBook(aBook);
        bookCollection.addBook(bBook);
        bookCollection.addBook(dBook);

        bookCollection.deleteBookByTitle("D");
        bookCollection.addBook(new Book("C"));
        List<Book> bookList = bookCollection.getCollection();

        bookList.sort(Comparator.comparing(Book::getTitle));
        assertEquals("A", bookList.get(0).getTitle());
        assertEquals("B", bookList.get(1).getTitle());
        assertEquals("C", bookList.get(2).getTitle());
    }
}
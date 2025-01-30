package org.example;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookCollectionTest {

    @Test
    void testListIsNotNull() {
        BookCollection bookCollection = new BookCollection();
        assertNotNull(bookCollection.getCollection());
    }

    @Test
    void sizeCheckTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals(3, bookCollection.getCollection().size());
    }

    @Test
    void bookPositionCheckTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals(secondBook, bookCollection.getCollection().get(1));
    }

   @Test
    void notDuplicateBookTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertFalse(bookCollection.duplicateChecker(bookCollection.getCollection()));
    }

    @Test
    void titlePositionTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        assertEquals("second Book", bookCollection.getCollection().get(1).getTittle());
    }

    @Test
    void addBookTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        Book fourthBook = new Book("fourth book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        bookCollection.addBookByPosition(1, fourthBook);
        assertEquals(fourthBook, bookCollection.getCollection().get(1));
    }

    @Test
    void listReductionTest() {
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("first book");
        Book secondBook = new Book("second Book");
        Book thirdBook = new Book("third book");
        Book fourthBook = new Book("fourth book");
        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);
        bookCollection.addBookByPosition(1, fourthBook);
        bookCollection.deleteBookByTitle("fourth book");
        assertEquals(3, bookCollection.getCollection().size());
    }

    @Test
    void orderListTest(){
        BookCollection bookCollection = new BookCollection();
        Book firstBook = new Book("A");
        Book secondBook = new Book("B");
        Book thirdBook = new Book("D");

        bookCollection.addBook(firstBook);
        bookCollection.addBook(secondBook);
        bookCollection.addBook(thirdBook);

        bookCollection.deleteBookByTitle("D");
        bookCollection.addBook(new Book("C"));
        List<Book> bookList = bookCollection.getCollection();

        bookList.sort(Comparator.comparing(Book::getTittle));
        assertEquals("A", bookList.get(0).getTittle());
        assertEquals("B", bookList.get(1).getTittle());
        assertEquals("C", bookList.get(2).getTittle());
    }

}
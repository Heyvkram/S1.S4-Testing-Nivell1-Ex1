package org.example;
import java.util.*;

public class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (!duplicateChecker(book)) {
            books.add(book);
        } else {
            System.out.println("The book already exists in the collection");
        }
    }

    public List<Book> getCollection() {
        return new ArrayList<>(books);
    }

    public String getBookByTitlePosition(int position) {
        if (position < 0 || position >= books.size()) {
            throw new IndexOutOfBoundsException();
        }
        return books.get(position).getTitle();
    }

    public void addBookByPosition(int position, Book book) {
        if (position < 0 || position > books.size()) {
            System.out.println("Invalid position");
            return;
        }
        if (!duplicateChecker(book)) {
            books.add(position, book);
        } else {
            System.out.println("The book already exists in the collection");
        }
    }

    public boolean duplicateChecker(Book bookToCheck) {
        for (Book book : books) {
            if (book.equals(bookToCheck)) {
                return true;
            }
        }
        return false;
    }

    public void deleteBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}

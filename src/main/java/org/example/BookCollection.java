package org.example;
import java.util.*;

public class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if(!duplicateChecker(books)){
            books.add(book);
        }else{
            System.out.println("the book already exists in the collection");
        }
    }

    public List<Book> getCollection() {
        return new ArrayList<>(books);
    }

    public String getBookByTittlePosition(int position) {
        if (position < 0 || position >=books.size()) {
            throw new IndexOutOfBoundsException();
        }
        return books.get(position).getTitle();
    }

    public void addBookByPosition(int position, Book book){
        if(!duplicateChecker(books)){
            books.add(position, book);
        }else{
            System.out.println("the book already exists in the collection");
        }
    }

    public boolean duplicateChecker(List<Book> books){
        Set<String> titles = new HashSet<>();
        for (Book book : books) {
            if (titles.contains(book.getTitle().toLowerCase())) {
                return true;
            }
            titles.add(book.getTitle().toLowerCase());
        }
        return false;
    }

    public void deleteBookByTitle(String title) {
       books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}

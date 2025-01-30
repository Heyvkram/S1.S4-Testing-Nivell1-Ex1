package org.example;
import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private ArrayList<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getCollection() {
        return new ArrayList<>(books);
    }

    public Book getBookByTittle(String tittle) throws CustomException {
        int i = 0;
        while ( i < books.size() ) {
            if (books.get(i).getTittle().equalsIgnoreCase(tittle)) {
                return books.get(i);
            }
            i++;
        }
        throw new CustomException("Book not found");
    }

    public boolean duplicateChecker(List<Book> books){
        int i = 0;
        while (i < books.size()) {
            int j = i + 1;
            while (j < books.size()) {
                if (books.get(i).getTittle().equalsIgnoreCase(books.get(j).getTittle())) {
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public void addBookByPosition(int position, Book book){
        books.add(position, book);
    }

    public void deleteBookByTitle(String title) {
        int i = 0;
        while ( i < books.size() ) {
            if (books.get(i).getTittle().equalsIgnoreCase(title)) {
                books.remove(i);
            }
            i++;
        }
    }
}

package ThirdLab;

import java.util.HashMap;

public class Library {
    private HashMap<String, Book> books;
    public Library() {
        books = new HashMap<>();
    }
    public void putBook(String isbn, Book book){
        books.put(isbn, book);
    }
    public Book getBook(String isbn){
        return books.get(isbn);
    }
    public boolean removeBook(String isbn){
        return books.remove(isbn) != null;
    }
    public boolean isEmpty(){
        return books.isEmpty();
    }
    public int size() {
        return books.size();
    }
}
class Book {
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

}

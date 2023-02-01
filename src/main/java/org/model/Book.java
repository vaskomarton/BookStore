package org.model;

public class Book {

    private final Author author;

    private final String isbn;

    private boolean isOnMarket = true;

    public Book(Author author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Author author, String isbn, boolean isOnMarket) {
        this(author, isbn);
        this.isOnMarket = isOnMarket;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isOnMarket() {
        return isOnMarket;
    }

    public void setOnMarket(boolean onMarket) {
        this.isOnMarket = onMarket;
    }
}

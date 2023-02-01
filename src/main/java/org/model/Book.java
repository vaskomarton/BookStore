package org.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @ManyToOne
    @JoinColumn(name = "author_isbn")
    private Author author;

    @Id
    private String isbn;

    private boolean isOnMarket = true;

    public Book(Author author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Author author, String isbn, boolean isOnMarket) {
        this(author, isbn);
        this.isOnMarket = isOnMarket;
    }

    public Book() {

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

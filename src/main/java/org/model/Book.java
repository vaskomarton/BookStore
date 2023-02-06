package org.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book extends Queryable{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @Id
    private int isbn;

    private String title;


    private boolean isOnMarket = true;

    public Book(Author author, String title) {
        this();
        this.author = author;
        this.author.addToWrittenBooks(this);
        this.isbn = generateIsbn();
        this.title = title;
    }

    public Book(Author author, String title, boolean isOnMarket) {
        this(author, title);
        this.isOnMarket = isOnMarket;
    }

    public Book() {
        super("FROM Book");
    }

    public Author getAuthor() {
        return author;
    }



    public boolean isOnMarket() {
        return isOnMarket;
    }

    public void setOnMarket(boolean onMarket) {
        this.isOnMarket = onMarket;
    }

    public int getIsbn() {
        return isbn;
    }

    private int generateIsbn() {
        int newIsbn = 0;
        for (int i = 0; i < 13; i++) {
            newIsbn += (int) (Math.random() * 10);
        }
        return newIsbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author.getName() +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isOnMarket=" + isOnMarket +
                '}';
    }
}

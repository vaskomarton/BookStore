package org.model;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Author {

    private long id;

    private final String name;

    private final Data birthDate;

    private ArrayList<Book> writtenBooks = new ArrayList<>();

    public Author(String name, Data birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Data getBirthDate() {
        return birthDate;
    }

    public ArrayList<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(ArrayList<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }
}

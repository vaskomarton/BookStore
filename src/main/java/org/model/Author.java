package org.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date birthDate;

    @OneToMany
    private List<Book> writtenBooks = new ArrayList<>();

    public Author(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Author() {

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
/*public ArrayList<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(ArrayList<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }*/
}

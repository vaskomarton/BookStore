package org.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Queryable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date birthDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> writtenBooks = new ArrayList<>();


    public Author(String name, Date birthDate, List<Book> writtenBooks) {
        this();
        this.name = name;
        this.birthDate = birthDate;
        this.writtenBooks = writtenBooks;
    }

    public Author() {
        super("FROM Author");
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
    public List<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(ArrayList<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    public void addToWrittenBooks(Book book) {
        writtenBooks.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}

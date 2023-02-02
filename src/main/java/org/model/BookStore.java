package org.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "book_store")
public class BookStore extends Queryable{

    @ElementCollection
    @MapKeyColumn(name="key_column")
    @Column(name="value_column")
    @CollectionTable(name="book_map", joinColumns=@JoinColumn(name="isbn"))
    private Map<Book, Integer> stock;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Address address;

    private boolean isActive = true;

    public BookStore() {
        super("FROM BookStore");
    }

    public Map<Book, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Book, Integer> stock) {
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "stock=" + stock +
                ", id=" + id +
                ", address=" + address +
                ", isActive=" + isActive +
                '}';
    }
}

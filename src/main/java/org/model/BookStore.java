package org.model;

import java.util.Map;

public class BookStore {

    private Map<Book, Integer> stock;

    private long id;

    private Address address;



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

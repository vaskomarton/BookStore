package org.model;

public abstract class Queryable {
    String query;

    Queryable(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

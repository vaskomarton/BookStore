package org.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.model.Book;
import org.model.Queryable;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();


    public void addObject(Object object) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(object);

        session.flush();

        session.getTransaction().commit();
    }

    public void printBooks(){
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<Book> q = session.createQuery("FROM Book", Book.class);
        for (Book p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        tx.commit();
    }

    public <T extends Queryable> void printAll(T t) {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();


        System.out.println(t.getClass().getName());


        String[] strings = t.getClass().getName().split("\\.");
        String name = strings[strings.length -1];

        Query<T> q = (Query<T>) session.createQuery(t.getQuery(), t.getClass());
        for (T p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        tx.commit();
    }



    @Override
    public void close() throws Exception {
        model.close();
    }
}
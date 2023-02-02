package org.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Book;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();


    public void addObject(Object object) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(object);

        session.flush();

        session.getTransaction().commit();
    }



    @Override
    public void close() throws Exception {
        model.close();
    }
}
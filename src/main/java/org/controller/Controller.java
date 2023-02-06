package org.controller;

import jakarta.persistence.Id;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Controller<T>{

    private HibernateContext model;

    private ArrayList<Integer> n = new ArrayList<>();

    private T t;

    public Controller(T t, HibernateContext model) {
        this.t = t;
        this.model = model;
    }


    public void addObject() {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        Field[] fields = t.getClass().getDeclaredFields();
        System.out.println(t);
        System.out.println(fields.length + " is the numbers of the fields");
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Id.class)){
                System.out.println(String.format("Set %s-s value. The type of the input shuld be %s", field.getName(), field.getType()));
                //field.set(t, );
            }
        }

//        session.persist(t);
//
//        session.flush();
//
//        session.getTransaction().commit();
    }

    //List
    public void printAll() {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String[] strings = t.getClass().getName().split("\\.");
        String name = strings[strings.length -1];

        Query<T> q = (Query<T>) session.createQuery(String.format("FROM %s", name), t.getClass());
        List<T> tList = new ArrayList<>(q.list());


        tList.forEach(System.out::println);
        session.clear();
        tx.commit();
    }

    //Delete
    public void delete(Long id){
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            T p = (T) session.find(t.getClass(), id);
            session.remove(p);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void modify(Long id) {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            T p = (T) session.find(t.getClass(), id);

            //session.remove(p);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void deactivate(long l) {

    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
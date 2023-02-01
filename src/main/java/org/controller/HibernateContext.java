package org.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.model.Address;
import org.model.Author;
import org.model.Book;
import org.model.BookStore;

import java.util.Properties;

public class HibernateContext implements AutoCloseable{
    private SessionFactory sessionFactory;

    private SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();

            properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.put("hibernate.connection.url", System.getenv("url"));
            properties.put("hibernate.connection.username", System.getenv("user"));
            properties.put("hibernate.connection.password", System.getenv("password"));

            properties.put("hibernate.current_session_context_class", "thread");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.hbm2ddl.auto", "update");


            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(BookStore.class);
            configuration.addAnnotatedClass(Author.class);



            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void close() throws Exception {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}

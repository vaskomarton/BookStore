package org.controller;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();
    /*
    public void testCase(){
        User user = new User(null, "Géza", new Date(123, 0, 30));

        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            addresses.add(new Address(user, "Hungary", "Budapest", "Bartók utca", (int) (Math.random() *100), (int) (Math.random() *100)));
        }
        user.setAddresses(addresses);

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        session.persist(user);

        session.flush();

        session.getTransaction().commit();
    }*/

    @Override
    public void close() throws Exception {
        model.close();
    }
}
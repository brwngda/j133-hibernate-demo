package pl.sda.hibernate.demo;

import org.hibernate.Session;

import static pl.sda.hibernate.demo.HibernateUtil.*;

public class Main {
    public static void main(String[] args) {
        Session session = INSTANCE.getSessionFactory().openSession();
        session.close();
    }
}

package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;

import static pl.sda.hibernate.demo.HibernateUtil.*;

public class Main {
    public static void main(String[] args) {
// wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy studenta
            Student student = new Student();
            student.setImie("Paweł");
            student.setDataUrodzenia(LocalDate.of(1990,1,3));
            student.setKierunekNauczania("Informatyka");
            student.setIndeks("123123");

            //zapisujemy studenta
            session.persist(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
package pl.sda.hibernate.demo;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class MainRead_SelectList {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

            // Hibernate Query Language - odmiana SQL'a tylko w hibernate
            // Tworzymy obiekt "Zapytanie o typ" (TypedQuery) gdzie tworzymy na obiekcie sesji zapytanie "SELECT [NIE PODANE] FROM [Student]"
            TypedQuery<Student> zapytanie = session.createQuery("from Student", Student.class);

            // Wywołujemy metodę 'getResultList', która oznacza (SELECT + z poprzedniej linii: FROM [Student])
            List<Student> listaWszystkichStudentow = zapytanie.getResultList();

            // Wypisz wyniki
            for (Student student : listaWszystkichStudentow) {
                System.out.println(listaWszystkichStudentow);
            }
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}
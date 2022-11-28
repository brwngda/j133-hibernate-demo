package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainUpdate_Update {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Student student = Student.builder()
                    .imie("Gaweł")
                    .kierunekNauczania("Filozofia")
                    .dataUrodzenia(LocalDate.of(1995, 6, 15))
                    .indeks("321321")
                    .id(2L)
                    .build();

            // SQL: UPDATE `student` SET ... WHERE id=X
            // Merge:
            // - służy do aktualizacji,
            // - wymaga podania id, co jest kryterium aktualizacji (aktualizujemy obieky o podanym id)
            // Persist:
            //  - służy do wstawiania NOWYCH rekordów do bazy,
            //  - przeważnie nie podaje się ID ponieważ jest generowane
            session.merge(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
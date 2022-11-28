package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainCreate_Insert {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // CREATE
            // READ
            // UPDATE
            // DELETE

            // Tworzymy studenta
//            Student student = new Student();
//            student.setImie("Paweł");
//            student.setDataUrodzenia(LocalDate.of(1990,1,3));
//            student.setKierunekNauczania("Informatyka");
//            student.setIndeks("123123");

//          Student student = new Student("Paweł", LocalDate.of(1990,1,3), "Informatyka", "123123");
            Student student = Student.builder()
                    .imie("Paweł")
                    .kierunekNauczania("Informatyka")
                    .dataUrodzenia(LocalDate.of(1990, 1, 3))
                    .indeks("123123")
                    .build();

            // SQL: INSERT INTO 'student' values (...)
            // zapisujemy studenta
            // Merge:
            // - służy do aktualizacji,
            // - wymaga podania id, co jest kryterium aktualizacji (aktualizujemy obieky o podanym id)
            // Persist:
            //  - służy do wstawiania NOWYCH rekordów do bazy,
            //  - przeważnie nie podaje się ID ponieważ jest generowane
            session.persist(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}
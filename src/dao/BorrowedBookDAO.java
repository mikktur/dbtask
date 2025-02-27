package dao;

import entity.Book;
import entity.BorrowedBook;
import entity.Student;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class BorrowedBookDAO {
    private EntityManager entityManager;

    public BorrowedBookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void borrowBook(Long studentId, Long bookId) {
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, studentId);
        Book book = entityManager.find(Book.class, bookId);

        if (student != null && book != null) {
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setStudent(student);
            borrowedBook.setBook(book);
            borrowedBook.setBorrowDate(LocalDate.now());

            entityManager.persist(borrowedBook);
        }

        entityManager.getTransaction().commit();
    }
}
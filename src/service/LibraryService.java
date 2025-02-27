package service;

import dao.*;
import entity.*;

public class LibraryService {
    private BookDAO bookDAO;
    private StudentDAO studentDAO;
    private BorrowedBookDAO borrowedBookDAO;
    private AuthorDAO authorDAO;
    private BiographyDAO biographyDAO;

    public LibraryService(BookDAO bookDAO, StudentDAO studentDAO, BorrowedBookDAO borrowedBookDAO, AuthorDAO authorDAO,BiographyDAO biographyDAO) {
        this.bookDAO = bookDAO;
        this.studentDAO = studentDAO;
        this.borrowedBookDAO = borrowedBookDAO;
        this.authorDAO = authorDAO;
        this.biographyDAO = biographyDAO;
    }

    public void registerStudent(String name) {
        Student student = new Student();
        student.setName(name);
        studentDAO.save(student);
    }

    public void registerBook(String title) {
        Book book = new PrintedBook();
        book.setTitle(title);
        bookDAO.save(book);
    }

    public void borrowBook(Long studentId, Long bookId) {
        borrowedBookDAO.borrowBook(studentId, bookId);
    }

    public void registerAuthor(String name, String details) {
        Author author = new Author();
        author.setName(name);
        Biography bio = new Biography();
        bio.setAuthor(author);
        bio.setDetails(details);
        author.setBiography(bio);
        authorDAO.save(author);

    }
}

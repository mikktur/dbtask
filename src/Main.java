import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        EntityManager em = emf.createEntityManager();


        BookDAO bookDAO = new BookDAO(em);
        StudentDAO studentDAO = new StudentDAO(em);
        BorrowedBookDAO borrowedBookDAO = new BorrowedBookDAO(em);
        AuthorDAO authorDAO = new AuthorDAO(em);
        BiographyDAO biographyDAO = new BiographyDAO(em);
        LibraryService libraryService = new LibraryService(bookDAO, studentDAO, borrowedBookDAO , authorDAO,biographyDAO);


        libraryService.registerStudent("Alice");
        libraryService.registerBook("Harry Potter");
        libraryService.registerAuthor("J.K. Rowling", "J.K Rowling is a british author");
        libraryService.borrowBook(1L, 1L);

        em.close();
        emf.close();
    }
}
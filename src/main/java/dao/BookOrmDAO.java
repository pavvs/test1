package dao;

import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */

public class BookOrmDAO {

    private EntityManager entityManager;

    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public Book getBook(int id) {
        return entityManager.find(Book.class, id);
    }

    public void putNewBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);

    }

    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        } else {
            throw new RuntimeException("Cannot delete book[" + id + "], because it doesn't exist.");
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager entityManager = emf.createEntityManager();

        BookOrmDAO bookOrmDAO = new BookOrmDAO();
        bookOrmDAO.setEntityManager(entityManager);

        Book b1 = new Book("title1", "autor1", 100, 100);

        entityManager.getTransaction().begin();
//        bookOrmDAO.putNewBook(b1);

        bookOrmDAO.deleteBook(6);
        List<Book> books = bookOrmDAO.getAllBooks();
        entityManager.getTransaction().commit();

        System.out.println(books);
    }
}

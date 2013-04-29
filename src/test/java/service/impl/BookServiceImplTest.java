package service.impl;

import entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
public class BookServiceImplTest {

    @Test
    public void saveTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/context.xml");

        BookService bookService = context.getBean("bookService", BookServiceImpl.class);
        EntityManager em = context.getBean("entityManager", EntityManager.class);

        em.getTransaction().begin();
        Book book = new Book();
        book.setAuthor("Kevin G.");
        book.setTitle("Java Book");
        book.setPrice(1000);
        book.setPages(100);

        bookService.save(book);

        em.getTransaction().commit();

    }
}

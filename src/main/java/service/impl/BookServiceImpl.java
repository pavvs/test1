package service.impl;

import dao.BookOrmDAO;
import entity.Book;
import service.BookService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 23:13
 */

public class BookServiceImpl implements BookService {

    private BookOrmDAO bookDao;

    @Override
    public void save(Book book) {
        bookDao.putNewBook(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.getAllBooks();
    }

    public BookOrmDAO getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookOrmDAO bookDao) {
        this.bookDao = bookDao;
    }
}

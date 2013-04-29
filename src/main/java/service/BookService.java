package service;

import entity.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public interface BookService {

    public void save(Book book);

    public List<Book> findAll();

}

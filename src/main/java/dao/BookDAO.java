package dao;

import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class BookDAO {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_MYSQL_URL = "jdbc:mysql://localhost:3306/jdbc1";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "winner";
    public static final String SELECT_ALL_BOOK = "select * from book";
    public static final String SELECT_BOOK_BY_ID = "select * from book where id = '%s';";
    public static final String INSERT_BOOK_QUERY =
            "insert into book (title, author, pages, price) values ('%s', '%s', '%s', '%s');";
    public static final String UPDATE_BOOK_QUERY =
            "update book set title = '%s', author = '%s', pages = '%s', price = '%s' where id = '%s';";
    public static final String DELETE_BOOK_QUERY = "delete from book where id = '%s';";

    private Connection connection;
    private Statement statement;

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_DRIVER);
        connection = DriverManager.getConnection(DB_MYSQL_URL, DB_USER, DB_PASSWORD);
        statement = connection.createStatement();
    }

    public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
        ResultSet rs = statement.executeQuery(SELECT_ALL_BOOK);
        List<Book> books = new ArrayList<Book>();
        while (rs.next()) {
            books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
        }
        return books;
    }

    public Book getBook(int id) throws SQLException {
        ResultSet rs = statement.executeQuery(String.format(SELECT_BOOK_BY_ID, id));
        rs.next();
        return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
    }

    public void putNewBook(Book book) throws ClassNotFoundException, SQLException {
        statement.executeUpdate(String.format(INSERT_BOOK_QUERY, book.getTitle(), book.getAuthor(), book.getPages(),
                book.getPrice()));
        System.out.println("New Book added.");
    }

    public void updateBook(Book book) throws SQLException {
        statement.executeUpdate(String.format(UPDATE_BOOK_QUERY, book.getTitle(), book.getAuthor(), book.getPages(),
                book.getPrice(), book.getId()));
    }

    public void deleteBook(int id) throws ClassNotFoundException, SQLException {
        Book deletingBook = getBook(id);
        statement.executeUpdate(String.format(DELETE_BOOK_QUERY, id));
        System.out.println("Book deleted: " + deletingBook);
    }

    public void badChangeAuthorAndPrice(int id, String newAuthor, double newPrice) throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.executeUpdate(String.format("update book set author = '%s' where id = '%s'", newAuthor, id));
//            if (true) throw new RuntimeException("bla-bla-bla");
            statement.executeUpdate(String.format("update book set price = '%s' where id = '%s'", newPrice, id));
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void goodChangeAuthorAndPrice(int id, String newAuthor, double newPrice) throws SQLException {
        connection.setAutoCommit(false);
        try {
            Book book = getBook(id);
            if (!book.getAuthor().equals(newAuthor)) {
                book.setAuthor(newAuthor);
                updateBook(book);
            }
//            if (true) throw new RuntimeException("bla-bla-bla");
            if (book.getPrice() != newPrice) {
                book.setPrice(newPrice);
                updateBook(book);
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BookDAO bookDAO = new BookDAO();
        bookDAO.init();

        bookDAO.badChangeAuthorAndPrice(3, "author3", 3000);

        List<Book> books = bookDAO.getAllBooks();
        System.out.println("Books: " + books);
        System.out.println();

//        bookDAO.putNewBook(new Book("title1", "author1", 100, 300));
//        System.out.println("Books: " + bookDAO.getAllBooks());
//        bookDAO.deleteBook(3);
    }
}

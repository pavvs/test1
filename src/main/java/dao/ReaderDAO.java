package dao;

import entity.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 26.04.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class ReaderDAO {

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_MYSQL_URL = "jdbc:mysql://localhost:3306/jdbc1";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "winner";
    public static final String SELECT_ALL_READERS = "select * from reader";
    public static final String SELECT_READER_BY_ID = "select * from reader where id = %s;";
    public static final String INSERT_READER_QUERY = "insert into reader (name, address) values ('%s', '%s');";
    public static final String DELETE_READER_QUERY = "delete from reader where id = %s;";

    private Connection connection;
    private Statement statement;

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_DRIVER);
        connection = DriverManager.getConnection(DB_MYSQL_URL, DB_USER, DB_PASSWORD);
        statement = connection.createStatement();
    }

    public List<Reader> getAllReaders() throws ClassNotFoundException, SQLException {
        ResultSet rs = statement.executeQuery(SELECT_ALL_READERS);
        List<Reader> readers = new ArrayList<Reader>();
        while (rs.next()) {
            readers.add(new Reader(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return readers;
    }

    public Reader getReader(int id) throws SQLException {
        ResultSet rs = statement.executeQuery(String.format(SELECT_READER_BY_ID, id));
        rs.next();
        return new Reader(rs.getInt(1), rs.getString(2), rs.getString(3));
    }

    public void putNewReader(Reader reader) throws ClassNotFoundException, SQLException {
        statement.executeUpdate(String.format(INSERT_READER_QUERY, reader.getName(), reader.getAddress()));
        System.out.println("New reader added.");
    }
    public void deleteReader(int id) throws ClassNotFoundException, SQLException {
        Reader deletingReader = getReader(id);
        statement.executeUpdate(String.format(DELETE_READER_QUERY, id));
        System.out.println("Reader deleted: " + deletingReader);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }


}

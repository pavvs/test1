package test;

import dao.ReaderDAO;
import entity.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 26.04.13
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ReaderDAO readerDAO = new ReaderDAO();
        readerDAO.init();
//        List<Reader> readers = readerDAO.getAllReaders();
//        System.out.println("Readers: " + readers);
//        System.out.println();

        readerDAO.putNewReader(new Reader("Dima", "Lvov"));
        System.out.println("Readers: " + readerDAO.getAllReaders());
        readerDAO.deleteReader(3);
    }
}

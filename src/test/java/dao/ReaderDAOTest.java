package dao;

import entity.Reader;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
public class ReaderDAOTest {

    public static final int READER_ID = 1;
    public static final String READER_NAME = "name1";
    public static final String READER_ADDRESS = "address1";

    @Test
    public void testGetReader() throws Exception {
        Statement statement = mock(Statement.class);
        ResultSet resultSet = mock(ResultSet.class);

        ReaderDAO service = new ReaderDAO();
        service.setStatement(statement);

        doReturn(resultSet).when(statement).executeUpdate(String.format(ReaderDAO.SELECT_READER_BY_ID, READER_ID));
//        doReturn(resultSet).when(statement).executeUpdate(any(String.class));     // always return resultSet
        doReturn(READER_ID).when(resultSet).getInt(1);
        doReturn(READER_NAME).when(resultSet).getString(2);
        doReturn(READER_ADDRESS).when(resultSet).getString(3);

        Reader actualReader = service.getReader(READER_ID);
        Reader expectedReader = new Reader(READER_ID, READER_NAME, READER_ADDRESS);

        assertEquals(expectedReader, actualReader);
        verify(resultSet, times(1)).next();
    }
}

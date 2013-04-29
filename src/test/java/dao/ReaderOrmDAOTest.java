package dao;

import entity.Phone;
import entity.Reader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public class ReaderOrmDAOTest {

    private ReaderOrmDAO readerOrmDAO;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager entityManager = emf.createEntityManager();
        readerOrmDAO = new ReaderOrmDAO();
        readerOrmDAO.setEntityManager(entityManager);
    }


    @Test
    public void testPutNewReader() throws Exception {

        readerOrmDAO.getEntityManager().getTransaction().begin();

        Reader newReader = new Reader("readerName3", "readerAdress3");

        Phone p1 = new Phone("22-22-333");
        p1.setReader(newReader);
        newReader.getPhones().add(p1);

        readerOrmDAO.putNewReader(newReader);

        readerOrmDAO.getEntityManager().getTransaction().commit();

        System.out.println(readerOrmDAO.getAllReaders());

    }


}

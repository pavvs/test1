package dao;

import entity.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class ReaderOrmDAO {
    private EntityManager entityManager;

    public List<Reader> getAllReaders() {
        return entityManager.createQuery("select r from Reader r", Reader.class).getResultList();
    }

    public Reader getReader(int id) {
            return entityManager.find(Reader.class, id);
    }

    public void putNewReader(Reader reader) {
        entityManager.persist(reader);
    }

    public void deleteReader(int id) {
        Reader deletingReader = entityManager.find(Reader.class, id);
        if (deletingReader != null) {
            entityManager.remove(deletingReader);
        } else {
            throw new RuntimeException("There is no reader by id=" + id);

        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager entityManager = emf.createEntityManager();
        ReaderOrmDAO readerOrmDAO = new ReaderOrmDAO();
        readerOrmDAO.setEntityManager(entityManager);
        Reader newReader = new Reader("readerName1","readerAdress1");

        entityManager.getTransaction().begin();

//        readerOrmDAO.putNewReader(newReader);
//          readerOrmDAO.deleteReader(6);

        entityManager.getTransaction().commit();
        System.out.println(readerOrmDAO.getAllReaders());
        System.out.println(readerOrmDAO.getReader(3));
    }
}


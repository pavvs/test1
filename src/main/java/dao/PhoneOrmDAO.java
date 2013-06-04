package dao;

import entity.Phone;
import entity.Reader;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 04.06.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class PhoneOrmDAO {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Phone> getAllPhones(){
        return entityManager.createQuery("select p from Phone p", Phone.class).
                getResultList();
    }

    public Phone getPhone(int id){
        return entityManager.find(Phone.class,id);
    }

    public void putNewPhone(Phone phone){
        entityManager.persist(phone);
    }

    public void deletePhone(int id){
        Phone deletingPhone = entityManager.find(Phone.class, id);
        if (deletingPhone != null) {
            entityManager.remove(deletingPhone);
        } else {
            throw new RuntimeException("There is no phone by id=" + id);

        }

    }

}

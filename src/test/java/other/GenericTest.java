package other;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 29.04.13
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class GenericTest<T extends Number, V, G> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "GenericTest{" +
                "object=" + object +
                '}';
    }

    private static <T> T getSomething(T param) {
        return param;
    }

    public static void main(String[] args) {
//        GenericTest<String> container = new GenericTest<String>();
//        container.setObject("Hello world!");
//        String str = container.getObject();
//
//        GenericTest container3 = new GenericTest();
//        GenericTest<Long, String, Double> container2 = new GenericTest<Long, String, Double>();
//        container2.setObject(6L);
//        Long l = container2.getObject();
//
//        String str2 = getSomething("String");
//        Integer int1 = getSomething(4);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

    }
}

package test;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.04.13
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
public class PersonFactory {
    private int defaultAge;

    public void setDefaultAge(int defaultAge) {
        this.defaultAge = defaultAge;
    }

    public Person createPerson(String name) {
        return new Person(name, defaultAge);
    }
}

package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.04.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class PersonsCollector {
    private static final Logger logger = LoggerFactory.getLogger(PersonsCollector.class);

    private List<Person> personList;
    private Set<Person> personSet;
    private Map<Integer, Person> personMap;
    private Properties personProperties;

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public void setPersonMap(Map<Integer, Person> personMap) {
        this.personMap = personMap;
    }

    public void setPersonProperties(Properties personProperties) {
        this.personProperties = personProperties;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mycontext.xml");
        Person person = context.getBean("person1", Person.class);
        logger.info(person.toString());
    }
}

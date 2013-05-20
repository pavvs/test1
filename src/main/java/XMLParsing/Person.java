package XMLParsing;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Calendar;
import java.util.Formatter;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 18.05.13
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
@SetValue(className = "Person.class", firstName = "Johan", lastName = "Silver", age = 50,
        addressAddress = "SomeStreet", addressCity = "SomeCity", addressCountry = "SomeCountry", married = true,
        profession = "seaman", salary = 10000, children = 2, birthdayYear = "1960", birthdayMonth = "01",
        birthdayDay = "14", speciality = "captain", gender = Gender.Male)
public class Person {
    @FieldValue("Ruslan")
    private String firstName;
    @FieldValue("Frankov")
    private String lastName;
    @FieldValue(value = "30")
    private int age;
    @FieldValue("Lenina street")
    private Address address;
    @FieldValue("true")
    private boolean married;
    @FieldValue("computer sciences")
    private String profession;
    @FieldValue( "2500.5")
    private double salary;
    @FieldValue("1")
    private int children;
    @FieldValue("1983.07.06")
    private Calendar birthday;
    @FieldValue("middle java developer")
    private Speciality speciality;
    @FieldValue("Male")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person(String firstName, String lastName, int age, Address address, boolean married, String profession,
                  double salary, int children, Calendar birthday, Speciality speciality, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.married = married;
        this.profession = profession;
        this.salary = salary;
        this.children = children;
        this.birthday = birthday;
        this.speciality = speciality;
        this.gender = gender;
    }

    public Person() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    private static Formatter formatCalendarToString(Calendar calendar){
            Formatter formatter = new Formatter();
           return formatter.format("%tY,%tm,%td", calendar,calendar,calendar);
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", married=" + married +
                ", profession='" + profession + '\'' +
                ", salary=" + salary +
                ", children=" + children +
                ", birthday=" + formatCalendarToString(birthday )+
                ", speciality=" + speciality +
                ", gender=" + gender +
                '}';
    }
}

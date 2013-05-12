package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 10.05.13
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "authors")
public class Author {
    private int authorId;
    private String FirstName;
    private String LastName;
    private Date Birthday;
    private String PhoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private List<Title> titleList = new ArrayList<Title>();

    @ManyToMany
    @JoinTable(name = "title_authors", joinColumns = {@JoinColumn(name = "au_id")},
            inverseJoinColumns = {@JoinColumn(name = "title_id")})

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "au_id",unique = true)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Column(name = "au_fname", nullable = false,length = 15)
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Column(name = "au_lname", nullable = false, length = 15)
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Column(name = "au_bdate")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    @Column(name = "phone", length = 12)
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Column(length = 20)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(length = 15)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(length = 2)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(length = 5)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

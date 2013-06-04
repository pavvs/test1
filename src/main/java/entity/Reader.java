package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 26.04.13
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Reader {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<Phone>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();

    public Reader() {
    }

    public Reader(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Reader(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (id != reader.id) return false;
        if (address != null ? !address.equals(reader.address) : reader.address != null) return false;
        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        if (phones != null ? !phones.equals(reader.phones) : reader.phones != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

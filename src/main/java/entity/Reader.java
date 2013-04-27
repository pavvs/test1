package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    @Override
    public boolean equals(Object obj) {
        Reader reader = (Reader) obj;
        return id == reader.id && name.equals(reader.name) && address.equals(reader.address);
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

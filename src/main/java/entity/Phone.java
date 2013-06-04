package entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 27.04.13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Phone {

    @Id
   @GeneratedValue
    private int id;

    @Column(name = "name")
    private String number;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Phone() {
    }
    public Phone(String number) {
        this.number = number;
    }
    public Phone (int id, String number){
        this.id = id;
        this.number = number;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (id != phone.id) return false;
        if (number != null ? !number.equals(phone.number) : phone.number != null) return false;
        if (reader != null ? !reader.equals(phone.reader) : phone.reader != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (reader != null ? reader.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        return "Phone{" +
//                "id=" + id +
//                ", number='" + number + '\'' +
//                ", reader=" + reader +
//                '}';
//    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}



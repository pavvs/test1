package XMLParsing;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.05.13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class Data {
    private Speciality speciality;

    public Data() {
    }

    public Data(Speciality speciality) {
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;

        Data data = (Data) o;

        if (speciality != null ? !speciality.equals(data.speciality) : data.speciality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return speciality != null ? speciality.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Data{" +
                "speciality=" + speciality +
                '}';
    }
}

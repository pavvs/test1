package XMLParsing;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.05.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class Speciality {
    private String specialityName;

    public Speciality() {
    }

    public Speciality(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speciality)) return false;

        Speciality that = (Speciality) o;

        if (specialityName != null ? !specialityName.equals(that.specialityName) : that.specialityName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return specialityName != null ? specialityName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "specialityName='" + specialityName + '\'' +
                '}';
    }

}

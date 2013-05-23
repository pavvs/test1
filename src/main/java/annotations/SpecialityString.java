package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 22.05.13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class SpecialityString {
    @TextValue
    private String speciality;

    public SpecialityString() {
    }

    public SpecialityString(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "SpecialityString{" +
                "speciality='" + speciality + '\'' +
                '}';
    }
}

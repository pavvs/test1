package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 9:39
 * To change this template use File | Settings | File Templates.
 */
public class AnnSpeciality {
    @TextValue
    private AnnText speciality;

    public AnnSpeciality() {
    }

    public AnnSpeciality(AnnText speciality) {
        this.speciality = speciality;
    }

    public AnnText getSpeciality() {
        return speciality;
    }

    public void setSpeciality(AnnText speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "AnnSpeciality{" +
                "speciality=" + speciality +
                '}';
    }
}

package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 9:43
 * To change this template use File | Settings | File Templates.
 */
public class AnnData {
//    @ElementValue("speciality")
//    private AnnSpeciality speciality;
//
//    public AnnData() {
//    }
//
//    public AnnData(AnnSpeciality speciality) {
//        this.speciality = speciality;
//    }
//
//    public AnnSpeciality getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(AnnSpeciality speciality) {
//        this.speciality = speciality;
//    }
//
//    @Override
//    public String toString() {
//        return "AnnData{" +
//                "speciality=" + speciality +
//                '}';
//    }
    @ElementValue("speciality")
    private SpecialityString specialityString;

    public AnnData() {
    }

    public AnnData(SpecialityString specialityString) {
        this.specialityString = specialityString;
    }

    public SpecialityString getSpecialityString() {
        return specialityString;
    }

    public void setSpecialityString(SpecialityString specialityString) {
        this.specialityString = specialityString;
    }

    @Override
    public String toString() {
        return "AnnData{" +
                "specialityString=" + specialityString +
                '}';
    }
}

package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public class AnnAddress {
    @AttributeValue("city")
    private String city;
    @AttributeValue("country")
    private String country;
    @AttributeValue("address")
    private String address;

    public AnnAddress() {
    }

    public AnnAddress(String city, String country, String address) {
        this.city = city;
        this.country = country;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AnnAddress{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

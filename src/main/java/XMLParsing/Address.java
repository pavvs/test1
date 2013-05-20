package XMLParsing;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.05.13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class Address {
    @FieldValue("City")
    private String city;
    @FieldValue("Country")
    private String country;
    @FieldValue("Address")
    private String address;

    public Address() {
    }

    public Address(String city, String country, String address) {
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

    public String getCountryCode() {
        return country;
    }

    public void setCountryCode(String countryCode) {
        this.country = countryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (city != null ? !city.equals(address1.city) : address1.city != null) return false;
        if (country != null ? !country.equals(address1.country) : address1.country != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

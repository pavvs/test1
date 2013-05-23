package annotations;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 */
public class AnnCustomer {
    @AttributeValue("firstName")
    private String firstName;
    @AttributeValue("lastName")
    private String lastName;
    @ElementValue(value = "address")
    private AnnAddress address;
    @ElementValue(value = "data")
    private AnnData data;

    public AnnCustomer() {
    }

    public AnnCustomer(String firstName, String lastName, AnnAddress address, AnnData data) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.data = data;
    }

    public AnnData getData() {
        return data;
    }

    public void setData(AnnData data) {
        this.data = data;
    }

    public AnnAddress getAddress() {
        return address;
    }

    public void setAddress(AnnAddress address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "AnnCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", data=" + data +
                '}';
    }
}

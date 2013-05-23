package annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public class AnnCustomersFactory {
    public List<AnnCustomer> createList(){
        List<AnnCustomer> annCustomerList = new ArrayList<AnnCustomer>(){{
//        add(new AnnCustomer("Alex", "Kaput", new AnnAddress("Kiyv","UA","street1"), new AnnData(
//                new AnnSpeciality(new AnnText("developer") ))));
//        add(new AnnCustomer("Bogdan", "Colla", new AnnAddress("Vilno", "UA", "street2"), new AnnData(
//                new AnnSpeciality(new AnnText("power engineer"))))); } }  ;
            add(new AnnCustomer("Alex", "Kaput", new AnnAddress("Kiyv","UA","street1"), new AnnData(
                new SpecialityString("developer" ))));
        add(new AnnCustomer("Bogdan", "Colla", new AnnAddress("Vilno", "UA", "street2"), new AnnData(
                new SpecialityString("power engineer")))); } }  ;

            return  annCustomerList;
    }
}

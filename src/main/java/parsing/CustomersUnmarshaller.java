package parsing;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 16.05.13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */


public class CustomersUnmarshaller {
    public List<Customer> unmarshallCustomers(String fileStringPathname) {
        List<Customer> customerList = new ArrayList<Customer>();
        File docFile = new File(fileStringPathname);
        Document document = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setValidating(true);
            dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage","customers.xsd");
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            document = documentBuilder.parse(docFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());  //To change body of catch statement use File | Settings | File Templates.
        }

        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();
        Node node;
        for (int i = 0; i < children.getLength(); i++) {
            node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                customerList.add(customerUnmarshaller(node));
            }
        }
        return customerList;
    }

    private static Customer customerUnmarshaller(Node customerNode) {
        Customer customer = new Customer();
        NamedNodeMap customerAttributes = customerNode.getAttributes();
        customer.setFirstName(customerAttributes.item(0).getNodeValue());
        customer.setLastName(customerAttributes.item(1).getNodeValue());
        Node addressNode = customerNode.getFirstChild().getNextSibling();
        customer.setAddress(unmarshallAddress(addressNode));
        Node dataNode = customerNode.getFirstChild().getNextSibling().getNextSibling().getNextSibling();
        customer.setData(unmarshallData(dataNode));
        return customer;
    }

    private static Address unmarshallAddress(Node addressNode) {
        Address address = new Address();
        NamedNodeMap addressNodeAttributes = addressNode.getAttributes();
        address.setCity(addressNodeAttributes.item(1).getNodeValue());
        address.setCountryCode(addressNodeAttributes.item(2).getNodeValue());
        address.setAddress(addressNodeAttributes.item(0).getNodeValue());
        return address;
    }

    private static Data unmarshallData(Node dataNode) {
        Data data = new Data();
        Node specialityNode = dataNode.getFirstChild().getNextSibling();
        data.setSpeciality(unmarshallSpeciality(specialityNode));
        return data;
    }

    private static Speciality unmarshallSpeciality(Node specialityNode) {
        Speciality speciality = new Speciality();
        Node textNode = specialityNode.getFirstChild();
        speciality.setSpecialityName(textNode.getNodeValue());
        return speciality;
    }

    public static void main(String[] args) {
        CustomersUnmarshaller customersUnmarshaller = new CustomersUnmarshaller();
        List<Customer> customerList = customersUnmarshaller.unmarshallCustomers("C:/XML_Docs/customers.xml");
        System.out.println("size = " + customerList.size());
        System.out.println(customerList);
    }

}

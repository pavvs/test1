package XMLParsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 17.05.13
 * Time: 9:52
 * To change this template use File | Settings | File Templates.
 */
public class CustomersListMarshaller {
    public void createXMLFile(List<Customer> customerList, String filePath) {
        int numberOfCustomers = customerList.size();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            document.setXmlStandalone(true);

            Element rootNode = document.createElement("customers");
            document.appendChild(rootNode);

            for (int i = 0; i < numberOfCustomers; i++) {
// Create Element customer
                Customer customer = customerList.get(i);
                Element customerNode = document.createElement("customer");
                customerNode.setAttribute("firstName", customer.getFirstName());
                customerNode.setAttribute("lastName", customer.getLastName());
                rootNode.appendChild(customerNode);
// Create siblings for customer
                Address address = customer.getAddress();
                Element addressNode = document.createElement("address");
                addressNode.setAttribute("city", address.getCity());
                addressNode.setAttribute("countryCode", address.getCountryCode());
                addressNode.setAttribute("address", address.getAddress());
                customerNode.appendChild(addressNode);

                Data data = customer.getData();
                Speciality speciality = data.getSpeciality();
                Element dataNode = document.createElement("data");
                Element specialityNode = document.createElement("speciality");
                Text specialityText = document.createTextNode(speciality.getSpecialityName());
                specialityNode.appendChild(specialityText);
                dataNode.appendChild(specialityNode);
                customerNode.appendChild(dataNode);
            }
// transform document to XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            try {
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(filePath));
                try {
                    transformer.transform(source, result);
                } catch (TransformerException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) {
        CustomersUnmarshaller customersUnmarshaller = new CustomersUnmarshaller();
        List<Customer> customerList = customersUnmarshaller.unmarshallCustomers("C:/XML_Docs/customers.xml");
        CustomersListMarshaller customersListMarshaller = new CustomersListMarshaller();
        customersListMarshaller.createXMLFile(customerList, "d:/new_customers.xml");
    }
}

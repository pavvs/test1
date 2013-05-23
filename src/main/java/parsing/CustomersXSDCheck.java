package parsing;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 18.05.13
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public class CustomersXSDCheck {
    public static void main(String[] args) throws ParserConfigurationException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File("customers.xsd"));
            Validator validator = schema.newValidator();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setSchema(schema);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("new_customers.xml"));
            DOMSource domSource = new DOMSource(document);
//            DOMResult result = new DOMReult( )
            validator.validate(domSource);

        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        }

    }
}

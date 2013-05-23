package annotations;

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
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 20.05.13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class AnnotatedListMarshaller {
    public void createXMLFile(List<? extends Object> objectList, String fileName) {
        int numberOfObjects = objectList.size();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            String rootNodeName = objectList.get(0).getClass().getSimpleName();
            Element rootNode = doc.createElement(rootNodeName + "s");
            doc.appendChild(rootNode);

            for (int i = 0; i < numberOfObjects; i++) {
                Object object = objectList.get(i);
                Element elementNode = doc.createElement(object.getClass().getSimpleName());
                Element elementNodeFilled = mainElementMarshaller(object,elementNode, rootNode, doc);
                rootNode.appendChild(elementNodeFilled);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            try {
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(fileName));
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private Element mainElementMarshaller(Object object,Element elementNode, Element parentNode, Document document)
            throws IllegalAccessException {
        Field fields[] = object.getClass().getDeclaredFields();
        if (0 != fields.length){
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(TextValue.class)) {
                    Text textNode = document.createTextNode((field.get(object)).toString());
                    elementNode.appendChild(textNode);
                }else if (field.isAnnotationPresent(AttributeValue.class)){
                    String attributeName = field.getAnnotation(AttributeValue.class).value();
                    elementNode.setAttribute(attributeName, (field.get(object)).toString());
                }else  if (field.isAnnotationPresent(ElementValue.class)){
                    String childNodeName = field.getAnnotation(ElementValue.class).value();
                    Element childNode = document.createElement(childNodeName);
                    Element childNodeFilled = mainElementMarshaller(field.get(object), childNode, elementNode, document);
                    elementNode.appendChild(childNodeFilled);
                }else {
                    Element tagNode = document.createElement(field.getName());
                    Element tagNodeFilled = mainElementMarshaller(field.get(object),tagNode,elementNode, document);
                    elementNode.appendChild(tagNodeFilled);
                }
            }
        } else {
            return elementNode;
        }
        return elementNode;
    }

    public static void main(String[] args) {
        AnnCustomersFactory annCustomersFactory = new AnnCustomersFactory();
        List<AnnCustomer> annCustomerList = annCustomersFactory.createList();
        AnnotatedListMarshaller marshaller = new AnnotatedListMarshaller();
        marshaller.createXMLFile(annCustomerList, "annCustomers.xml");
        System.out.println(annCustomerList);
    }
}

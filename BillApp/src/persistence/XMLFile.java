package billapp.persistence;

import billapp.logic.Employee;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jf
 */
public class XMLFile {
    private DocumentBuilderFactory docFactory;  /** Document builder factory */
    private DocumentBuilder docBuilder;         /** Document builder */

    /**
     * Default constructor
     */
    public XMLFile() {
    }

    /**
     * Get Document builder factory
     * @return Document builder factory
     */
    public DocumentBuilderFactory getDocFactory() {
        return docFactory;
    }

    /**
     * Set Document builder factory
     * @param docFactory Document builder factory
     */
    public void setDocFactory(DocumentBuilderFactory docFactory) {
        this.docFactory = docFactory;
    }

    /**
     * Get Document builder
     * @return Document builder
     */
    public DocumentBuilder getDocBuilder() {
        return docBuilder;
    }

    /**
     * Set Document builder
     * @param docBuilder Document builder
     */
    public void setDocBuilder(DocumentBuilder docBuilder) {
        this.docBuilder = docBuilder;
    }

    /**
     * Read a xml file and copy data into a employee object
     * @param filename XML filename
     * @return Employee list
     */
    public List<Employee> selectEmployee(String filename) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
            Document doc = this.getDocBuilder().parse(filename);

            Element rootElement = doc.getDocumentElement();
            NodeList xmlList = rootElement.getElementsByTagName("Employee");

            if (xmlList != null && xmlList.getLength() > 0) {
                for (int i = 0; i < xmlList.getLength(); i++) {
                    Element element = (Element)xmlList.item(i);
                    Employee employee = getEmployee(element);
                    employeeList.add(employee);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return employeeList;
    }

    /**
     * Take an employee element and read the values
     * @param element Element
     * @return Employee object
     */
    private Employee getEmployee(Element element) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Employee employee = new Employee();

        try {
            employee.setId(Long.parseLong(element.getAttribute("id")));
            employee.setFirstname(getTagValue(element, "firstname"));
            employee.setLastname(getTagValue(element, "lastname"));
            employee.setPhoto(getTagValue(element, "photo"));
            employee.setGender(Integer.parseInt(getTagValue(element, "gender")));
            employee.setBornDate(dateFormat.parse(getTagValue(element, "bornDate")));
            employee.setHiredDate(dateFormat.parse(getTagValue(element, "hiredDate")));
            employee.setSalary(Integer.parseInt(getTagValue(element, "salary")));
        } catch (ParseException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employee;
    }

    /**
     * Take a xml element and the tag name, look for the tag an get your value
     * @param element Element
     * @param tagName Element name
     * @return Employee tag value
     */
    private String getTagValue(Element element, String tagName) {
        String textVal = null;
        NodeList nl = element.getElementsByTagName(tagName);
        if ((nl != null) && (nl.getLength() > 0)) {
            Element tagElement = (Element)nl.item(0);
            try {
                textVal = tagElement.getFirstChild().getNodeValue();
            }
            catch (NullPointerException ex) {
                textVal = "";
            }
        }
        return textVal;
    }

    /**
     * Write a XML file
     * @param employeeList Employee list
     * @param filename Employee filename
     */
    public void writeEmployee(List<Employee> employeeList, String filename) {
        try {
            this.setDocFactory(DocumentBuilderFactory.newInstance());
            this.setDocBuilder(this.getDocFactory().newDocumentBuilder());

            Document doc = this.getDocBuilder().newDocument();
            Element rootElement = doc.createElement("Employees");
            doc.appendChild(rootElement);

            for (Employee employee : employeeList) {
                rootElement.appendChild(setEmployee(doc, employee));
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Build employee xml record
     * @param doc Document
     * @param employee Employee
     * @return Employee element node
     */
    private Node setEmployee(Document doc, Employee employee) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Element element = doc.createElement("Employee");

        element.setAttribute("id", "" + employee.getId());
        element.appendChild(setTag(doc, element, "firstname", employee.getFirstname()));
        element.appendChild(setTag(doc, element, "lastname", employee.getLastname()));
        element.appendChild(setTag(doc, element, "photo", employee.getPhoto()));
        element.appendChild(setTag(doc, element, "gender", "" + employee.getGender()));
        element.appendChild(setTag(doc, element, "bornDate", dateFormat.format(employee.getBornDate())));
        element.appendChild(setTag(doc, element, "hiredDate", dateFormat.format(employee.getHiredDate())));
        element.appendChild(setTag(doc, element, "salary", "" + employee.getSalary()));

        return element;
    }

    /**
     * Build employee xml tag
     * @param doc Document
     * @param element Employee xml element
     * @param tagName Tag name
     * @param tagValue Tag value
     * @return Employee field tag
     */
    private Node setTag(Document doc, Element element, String tagName, String tagValue) {
        Element node = doc.createElement(tagName);
        node.appendChild(doc.createTextNode(tagValue));
        return node;
    }
}

import org.w3c.dom.*;

//import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ParseXML {

    public static List<Employee> parseXML(String fileXML) {
        List<String> elements = new ArrayList<>();
        List<Employee>employees = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileXML));
            Node root = doc.getDocumentElement();
            NodeList nodeList = root.getChildNodes(); //лиcт из элементов эмплои

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i); //первый элемент
                if (node.getNodeName().equals("employee")) {
                    NodeList nodeList1 = node.getChildNodes();
                    for (int j = 0; j < nodeList1.getLength(); j++) {
                        Node node_ = nodeList1.item(j);
                        if (Node.ELEMENT_NODE == node_.getNodeType()) {
                            elements.add(node_.getTextContent());
                        }
                    }
                    employees.add(new Employee(
                            Long.parseLong(elements.get(0)),
                            elements.get(1),
                            elements.get(2),
                            elements.get(3),
                            Integer.parseInt(elements.get(4))));
                    elements.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}

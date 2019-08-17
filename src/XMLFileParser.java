import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLFileParser implements FileParser {
    @Override
    public void read() {
        try {
            File inputFile = new File("SI2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Type :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("note");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("to: "
                            + eElement.getAttribute("to"));
                    System.out.println("from: "
                            + eElement
                            .getElementsByTagName("from")
                            .item(0)
                            .getTextContent());
                    System.out.println("heading : "
                            + eElement
                            .getElementsByTagName("heading")
                            .item(0)
                            .getTextContent());
                    System.out.println("body : "
                            + eElement
                            .getElementsByTagName("body")
                            .item(0)
                            .getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }


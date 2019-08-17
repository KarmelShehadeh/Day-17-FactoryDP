import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;

public class XMLFileParser implements FileParser {
    @Override
    public void pars() {
        try {
            FileWriter resultFile=new FileWriter("D:\\result.txt");//txt file to print the result in it

            File inputFile = new File("SI2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            resultFile.write("Type :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("note");
            resultFile.write("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    resultFile.write("to: "
                            + eElement.getAttribute("to"));
                    resultFile.write("from: "
                            + eElement
                            .getElementsByTagName("from")
                            .item(0)
                            .getTextContent());
                    resultFile.write("heading : "
                            + eElement
                            .getElementsByTagName("heading")
                            .item(0)
                            .getTextContent());
                    resultFile.write("body : "
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


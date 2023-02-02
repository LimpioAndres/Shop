package com.solvd.shop.parsers.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;

public class DomParser {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DomParser.class);

    public static void main(String[] args){

        String fileXml = "C:\\Users\\gatm_\\Desktop\\SOLVD\\shop\\src\\main\\resources\\xml\\ordersU.xml";

        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document document = dbBuilder.parse(new File(fileXml));

            NodeList nodesOrders = document.getElementsByTagName("orders");

            for (int iterator = 0; iterator < nodesOrders.getLength(); iterator++){
                Node node = nodesOrders.item(iterator);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    NodeList childs = element.getChildNodes();

                    for (int iterator2 = 0; iterator2 < childs.getLength(); iterator2++) {
                        Node child = childs.item(iterator2);

                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            LOGGER.info("Column: " + child.getNodeName() + " | Value: " + child.getTextContent());
                        }
                    }
                    LOGGER.info("\n" + "");
                }
            }
        }catch(ParserConfigurationException | SAXException | IOException ex){
            LOGGER.info("\n" + ex.getMessage());
        }
    }

}

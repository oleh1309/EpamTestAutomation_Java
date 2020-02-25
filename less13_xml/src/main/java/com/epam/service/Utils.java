package com.epam.service;

import com.epam.model.Chars;
import com.epam.model.Parameters;
import com.epam.model.Planes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static void parseXmlToObjectDOM(String path) throws ParserConfigurationException, IOException, SAXException {
        List<Planes> planesList = new ArrayList<>();
        Planes planes = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(path));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("Plane");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                //Create new Planes Object
                planes = new Planes();
                planes.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
                planes.setOrigin(eElement.getElementsByTagName("origin").item(0).getTextContent());
                int numOfSeats = Integer.parseInt(eElement.getElementsByTagName("numberOfSeats").item(0).getTextContent());
                String type = eElement.getElementsByTagName("typeOfPlane").item(0).getTextContent();
                boolean isRackets = Boolean.parseBoolean(eElement.getAttribute("combatKit"));
                int rakets = Integer.parseInt(eElement.getElementsByTagName("rakets").item(0).getTextContent());
                boolean availabilityOfRadar = Boolean.parseBoolean(eElement.getAttribute("availabilityOfRadar"));
                planes.setChars(new Chars(type,numOfSeats,availabilityOfRadar,rakets));
                planes.setParameters(new Parameters(Integer.parseInt(eElement.getElementsByTagName("length").item(0).getTextContent()),
                        Integer.parseInt(eElement.getElementsByTagName("width").item(0).getTextContent()),
                        Integer.parseInt(eElement.getElementsByTagName("height").item(0).getTextContent())));
                planes.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));

                //Add Planes to list
                planesList.add(planes);
            }
        }
        logger.info("DOM \n" +planesList + "\n");
    }

    public static String convert(String xsl, String xml, String html) {
        String res="";
        Source xslDoc = new StreamSource(xsl);
        Source xmlDoc = new StreamSource(xml);
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            OutputStream htmlFile = new FileOutputStream(html);
            Transformer transform = tFactory.newTransformer(xslDoc);
            transform.transform(xmlDoc, new StreamResult(htmlFile));
            res = "Created successfully: "+html;
        } catch (FileNotFoundException | TransformerException e) {
            res = e.getMessage();
        }
        return res;
    }

    public static void validate(String xsd, String xml) {
        String res= "";
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(new FileInputStream(xml));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));
            res="xml file " + xml + " is valid!";
        } catch (XMLStreamException | SAXException | IOException e) {
            logger.error(e);
        }
        logger.info(res);
    }

    public static void parseXmlToObjectSaX(String path){
        File file = new File(path);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        CustomSAXPars saxp = new CustomSAXPars();
        try {
            Objects.requireNonNull(parser).parse(file, saxp);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        logger.info("SaX \n" + saxp.getResult() + "\n");

    }
}

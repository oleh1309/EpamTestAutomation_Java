package com.epam.service;

import com.epam.model.Chars;
import com.epam.model.Parameters;
import com.epam.model.Planes;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class CustomSAXPars extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(CustomSAXPars.class);
    private Planes planes;
    private String thisElement = "";
    private Chars chars;
    private Parameters parameters;
    private List<Planes> planesList;


    public List<Planes> getResult() {
        return planesList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
        planesList = new LinkedList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (qName.equalsIgnoreCase("Planes")) {
            logger.info(atts.getValue("model"));
            planes = new Planes();
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("Planes")) {
            planes.setChars(chars);
            planesList.add(planes);
            planes.setParameters(parameters);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("model")) {
            planes.setModel(new String(ch, start, length));
        } else if (thisElement.equals("origin")) {
            planes.setOrigin(new String(ch, start, length));
        } else if (thisElement.equalsIgnoreCase("chars")) {
            chars = new Chars();

        } else if (thisElement.equalsIgnoreCase("typeOfPlane")) {
            chars.setType(new String(ch, start, length));
        } else if (thisElement.equalsIgnoreCase("numberOfSeats")) {
            int res = Integer.parseInt(new String(ch, start, length));
            chars.setNumberOfSeats(res);
        } else if (thisElement.equalsIgnoreCase("combatKit")) {
            chars.setCombatKit(Boolean.parseBoolean(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("rakets")) {
            chars.setRacket(Integer.parseInt(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("availabilityOfRadar")) {
            chars.setAvailabilityOfRadar(Boolean.parseBoolean(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("parameters")) {
            parameters = new Parameters();

        } else if (thisElement.equalsIgnoreCase("length")) {
            parameters.setLength(Integer.parseInt(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("width")) {
            parameters.setWidth(Integer.parseInt(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("height")) {
            parameters.setHeight(Integer.parseInt(new String(ch, start, length)));
        } else if (thisElement.equalsIgnoreCase("price")) {
            planes.setPrice(Integer.parseInt(new String(ch, start, length)));
        }
    }

    @Override
    public void endDocument() {
        logger.info("Stop parse XML...");
    }

}

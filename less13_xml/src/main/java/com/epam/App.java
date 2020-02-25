package com.epam;

import com.epam.model.Chars;
import com.epam.model.Parameters;
import com.epam.model.Planes;
import com.epam.model.Type;
import com.epam.service.Utils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Objects;

public class App {

    public static void main(String[] args){
        //model
        Planes planes = new Planes("Wer","Uk"
                ,new Chars(Type.SCOUT.toString(),2,true,2)
                ,new Parameters(2,3,5.2),78);
        System.out.println(planes);
        //path
        String PATH_XML_FILE = Objects.requireNonNull(App.class.getClassLoader().getResource("Test.xml")).getPath();
        String PATH_XSL_FILE = Objects.requireNonNull(App.class.getClassLoader().getResource("Test.xsl")).getPath();
        String PATH_HTML_FILE = Objects.requireNonNull(App.class.getClassLoader().getResource("New.html")).getPath();
        String PATH_XSD_FILE = Objects.requireNonNull(App.class.getClassLoader().getResource("Test.xsd")).getPath();
        //convert from xml to html
        System.out.println(Utils.convert(PATH_XSL_FILE, PATH_XML_FILE, PATH_HTML_FILE));
        //convert from xml to Object
        try {
            //DOM
            Utils.parseXmlToObjectDOM(PATH_XML_FILE);
            //SaX
            Utils.parseXmlToObjectSaX(PATH_XML_FILE);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        //validate
        Utils.validate(PATH_XSD_FILE,PATH_XML_FILE);


    }
}

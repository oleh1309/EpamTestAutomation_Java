package com.epam.parsers;

import com.epam.model.Planes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JacksonParser {
    private static final Logger logger = LogManager.getLogger(JacksonParser.class);
    private ObjectMapper objectMapper;
    private List<Planes> planesList;

    public JacksonParser() {
        this.objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setVisibilityChecker(
                VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public void readJSON(String path){
        Planes[] staff = new Planes[0];
        try {
            staff = objectMapper.readValue(new FileReader(path), Planes[].class);
        } catch (IOException e) {
            logger.error(e);
        }
        planesList = Arrays.asList(staff);
        for (Planes planes: planesList) {
            logger.info(planes);
        }

    }

    public void writeJSON(String path){
        try {
            objectMapper.writeValue(new FileWriter(path), planesList);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public List getList(){
        return planesList;
    }
}

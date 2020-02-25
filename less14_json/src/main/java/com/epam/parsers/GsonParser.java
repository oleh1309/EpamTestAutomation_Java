package com.epam.parsers;

import com.epam.model.Planes;
import com.epam.service.CustomSAXPars;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class GsonParser {
    private static final Logger logger = LogManager.getLogger(GsonParser.class);
    private Gson gson;
    private List<Planes> planesList;

    public GsonParser() {
        this.gson = new Gson();
    }

    public void readFromJSON(String jsonFile){
        try (Reader reader = new FileReader(jsonFile)) {
            // Convert JSON File to Java Object
            Planes[] staff = gson.fromJson(reader, Planes[].class);
            planesList = Arrays.asList(staff);
        } catch (IOException e) {
            logger.error(e);
        }
        // print staff
        for (Planes planes: planesList) {
            logger.info(planes);
        }
    }

    public void writeToJSON(String jsonFile){
        gson = new GsonBuilder().setPrettyPrinting().create();
        // Java objects to String
        String json = gson.toJson(planesList);
        // Java objects to File
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(json, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List getList(){
        return planesList;
    }

}

package com.epam;

import com.epam.parsers.GsonParser;
import com.epam.parsers.JacksonParser;
import com.epam.validators.ValidatorsJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.Objects;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    private static String PATH_JSON_FILE = Objects.requireNonNull(
            Application.class.getClassLoader().getResource("Test.json")).getPath();
    private static String PATH_NEWJSON_FILE = Objects.requireNonNull(
            Application.class.getClassLoader().getResource("NewTestGSON.json")).getPath();
    private static String PATH_NEWJSON1_FILE = Objects.requireNonNull(
            Application.class.getClassLoader().getResource("NewTestJACKSON.json")).getPath();
    private static String PATH_SHEMA_FILE = Objects.requireNonNull(
            App.class.getClassLoader().getResource("shemma.json")).getPath();

    public static void main(String[] args) {
        logger.info("Reading from JSON file using (GSON library)....");
        GsonParser gsonParser = new GsonParser();
        gsonParser.readFromJSON(PATH_JSON_FILE);
        logger.info("Writing to JSON file using (GSON library)....");
        gsonParser.writeToJSON(PATH_NEWJSON_FILE);

        logger.info("Reading from JSON file using (JACKSON library)....");
        JacksonParser jacksonParser = new JacksonParser();
        jacksonParser.readJSON(PATH_JSON_FILE);
        logger.info("Writing to JSON file using (JACKSON library)....");
        jacksonParser.writeJSON(PATH_NEWJSON1_FILE);

        logger.info("Validating....");
        logger.info("Result of validation: " +
                ValidatorsJSON.validate(new File(PATH_JSON_FILE), new File(PATH_SHEMA_FILE)));

        logger.info("Comparing...\n" + jacksonParser.getList().equals(gsonParser.getList()));

    }
}

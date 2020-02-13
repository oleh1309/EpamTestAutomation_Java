package com.epam.model;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static String reading(){
        String result ="";
        File file = new File(
                Utils.class.getClassLoader().getResource("Test.txt").getFile());
        try(FileInputStream fin=new FileInputStream(file)){
            result = IOUtils.toString(fin, StandardCharsets.UTF_8);
        }catch(Exception e){logger.error(e);}
        return result;
    }

}

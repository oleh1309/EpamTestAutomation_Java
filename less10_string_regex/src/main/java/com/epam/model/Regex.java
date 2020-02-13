package com.epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final Logger logger = LogManager.getLogger(Regex.class);
    private static Matcher matcher;
    private static Pattern pattern;
    public static void checkText(String text) {
        pattern = Pattern.compile("\\.*[A-Z]|\\d{2}(\\/)\\d{2}(\\/)\\d{4}$");
        setMatcher(pattern,text);
    }

    public static void splitText(String text) {
        pattern = Pattern.compile("the|you");
        setMatcher(pattern,text);
        String[] newString = text.split(pattern.toString(),3);
        logger.info("String split");
        for (String s : newString) {
            logger.info(s);
        }
    }

    public static void replaceVowels(String text){
        logger.info(text);
        pattern = Pattern.compile("[aeyuio]");
        String newString = text.replaceAll(pattern.toString(),"-");
        logger.info(newString);
    }

    private static void setMatcher(Pattern pattern, String text){
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            logger.info("Start index: " + matcher.start() + " End index: " + matcher.end() + " " + matcher.group());
        }
    }


}

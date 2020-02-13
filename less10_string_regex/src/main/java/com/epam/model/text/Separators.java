package com.epam.model.text;

public class Separators extends Char{
    public static final String COMA = ",";
    public static final String DOT = ".";
    public static final String EXCLAMATION_MARK = "!";
    public static final String QUESTION_MARK = "?";
    public static final String SEMICOLON = ";";
    public static final String COLON = ":";
    public static final String SPACE = " ";
    public static final String ENTER = "\n";
    private String[] SEPARATE_SENTENCE;
    private String separator;

    public Separators(String s) {
        SEPARATE_SENTENCE = new String[]{COMA, DOT, EXCLAMATION_MARK,
                QUESTION_MARK, SEMICOLON, COLON, SPACE};
        this.separator = getSeparator(s);

    }

    private String getSeparator(String separator){
        String res = "";
        for (String s : SEPARATE_SENTENCE) {
            if(s.equals(separator)){
                res = s;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Separators{" + separator + '}';
    }
}

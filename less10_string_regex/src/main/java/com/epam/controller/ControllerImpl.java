package com.epam.controller;

import com.epam.model.Regex;
import com.epam.model.StringUtil;

public class ControllerImpl implements Controller {

    @Override
    public StringUtil getUtils(Object... args) {
        return new StringUtil(args);
    }

    @Override
    public void multiplyRegex(String s) {
        Regex.checkText(s);
    }

    @Override
    public void splitString(String s) {
        Regex.splitText(s);
    }

    @Override
    public void replaceWord(String s) {
        Regex.replaceVowels(s);
    }
}

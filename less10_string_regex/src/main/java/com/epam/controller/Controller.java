package com.epam.controller;

import com.epam.model.StringUtil;

public interface Controller {

    StringUtil getUtils(Object... args);
    void multiplyRegex(String s);
    void splitString(String s);
    void replaceWord(String s);

}

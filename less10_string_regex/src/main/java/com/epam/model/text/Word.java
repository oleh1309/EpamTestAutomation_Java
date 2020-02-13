package com.epam.model.text;

import java.util.Objects;

public class Word extends Char implements Comparable<Word>{

    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {

    }

    public String getWord() {
        return word;
    }

    @Override
    public int getLength(){
        return word.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "{" + word +
                '}';
    }

    @Override
    public int compareTo(Word o) {
        return word.compareTo(o.getWord());
    }
}

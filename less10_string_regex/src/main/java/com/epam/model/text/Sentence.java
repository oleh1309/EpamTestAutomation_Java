package com.epam.model.text;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sentence extends Char implements Comparable<Sentence>{

    private List<Object> list;
    private int length;
    public Sentence(String text) {
        this.length = text.replaceAll(" ","").length();
        list = new LinkedList<>();
        parseString(text);
    }

    public void parseString(String text) {
        String[] temp = text.split(" ");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].contains(Separators.COMA) ||
                    temp[i].contains(Separators.DOT) ||
                    temp[i].contains(Separators.QUESTION_MARK) ||
                    temp[i].contains(Separators.EXCLAMATION_MARK)) {
                list.add(new Word(temp[i].substring(0, temp[i].length() - 1)));
                list.add(new Separators(temp[i].substring(temp[i].length() - 1)));
            } else {
                list.add(new Word(temp[i]));
            }
        }
    }

    public Map<Object, Integer> countByStreamToMap() {
        int countInt = 1;
        return list.stream().collect(Collectors.toMap(Function.identity(), v -> countInt, Integer::sum));
    }

    public Object getCountWords() {
        Optional op = countByStreamToMap().entrySet()
                .stream()
                .filter(a -> a.getValue() > 1)
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getValue);
        return op.isPresent() ? op.get() : null;
    }

    public int getSizeOfSentence(){
        return list.size();
    }

    public List<Object> getList() {
        return list;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public int compareTo(Sentence o) {
        return 0;
    }
}

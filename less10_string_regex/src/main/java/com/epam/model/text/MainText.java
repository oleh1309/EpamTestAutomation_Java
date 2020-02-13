package com.epam.model.text;

import com.epam.model.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MainText {
    private static final Logger logger = LogManager.getLogger(MainText.class);
    private List<Sentence> sentenceList;


    public MainText() {
        sentenceList = new ArrayList<>();
        this.sentenceList = parseMaintext();
        sentenceList.forEach(a -> logger.info(a));

        logger.info("\n Task 1 \n");
        getMaxDuplicatedWords().forEach((a, b) -> logger.info(a + " " + b));
//        logger.info("\n Task 2 \n");
//        getSentencesLength().forEach((a,b) -> logger.info(a + " " + b));
        //sentenceWordMap.forEach((a, b) -> logger.info(a + " " + b));
        logger.info("\n Task 2 \n");
        getSentencesBySize().forEach((a, b) -> logger.info(a + " " + b));
        logger.info("\n Task 3 \n");
        logger.info(getUniqeWord());

    }

    private List<Sentence> parseMaintext() {
        String[] temp = Utils.reading().split("(?<=[.?!])");
        for (String word : temp) {
            sentenceList.add(new Sentence(word.trim().replaceAll("\\s{2,}", " ")));
        }
        return sentenceList;
    }

    private Map<Sentence, Integer> getMaxDuplicatedWords() {
        Map<Sentence, Integer> sentenceWordMap = new HashMap<>();
        sentenceList.forEach(a -> {
            if (a.getCountWords() != null) {
                sentenceWordMap.put(a, (Integer) a.getCountWords());
            }
        });
        return sentenceWordMap.entrySet()
                .stream()
                .sorted((Entry.<Sentence, Integer>comparingByValue().reversed()))
                .collect(Collectors.
                        toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

    private Map<Sentence, Integer> getSentencesLength() {
        Map<Sentence, Integer> sentenceWordMap = new HashMap<>();
        sentenceList.forEach(a -> {
            sentenceWordMap.put(a, a.getLength());
        });
        return sentenceWordMap;
    }

    private Map<Sentence, Integer> getSentencesBySize() {
        Map<Sentence, Integer> sentenceWordMap = new HashMap<>();
        sentenceList.forEach(a -> {
            sentenceWordMap.put(a, a.getSizeOfSentence());
        });
        Map<Sentence, Integer> sortedMap = new TreeMap<>(Comparator.comparingInt(Sentence::getSizeOfSentence));
        sortedMap.putAll(sentenceWordMap);
        return sortedMap;
    }

    private String getUniqeWord() {
        String uniqe = "";
        boolean tr = true;
        for (Sentence s : sentenceList) {
            for (int i = 0; i < s.getList().size(); i++) {
                if (!tr) {
                    break;
                } else {
                    for (int j = 1; j < sentenceList.size(); j++) {
                        tr = sentenceList.get(j).getList().contains(s.getList().get(i));
                        if (!tr) {
                            uniqe = s.getList().get(i).toString();
                            break;
                        }
                    }
                }
            }
            break;
        }

        return uniqe;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }
}

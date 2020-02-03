package epam.task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void addToList(List list){
        list.add("0067");
        list.add("bb");
    }

    public static void main(String[] args) {
        //task4
        List<Integer> list = new ArrayList<>();
        list.add(5);
        addToList(list);
        list.add(7);
        for (Object o: list) {
            logger.info(o);
        }
    }
}

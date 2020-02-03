package epam.task4_5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        //Task2
        Ship<Droid> ship = new Ship();
        ship.setDroid(new Droid("Desert"));
        ship.setDroid(new Droid("Kalag"));
        logger.info(ship.getDroid());


        List<ModernDroid> modernDroidList = new ArrayList<>();
        modernDroidList.add(new ModernDroid("ferr",55));
        modernDroidList.add(new ModernDroid("feree",50));

        List<SuperDroid> superDroidList = new ArrayList<>();
        superDroidList.add(new SuperDroid("ferr",55,10));
        superDroidList.add(new SuperDroid("feree",50, 12));

        ship.setAll(modernDroidList);
        ship.setAll(superDroidList);
        logger.info(ship.getDroid());
        //Task3
        Queue<SuperDroid> deque = new PriorityQueue<>();
        deque.add(new SuperDroid("AAAA", 45,2));
        deque.add(new SuperDroid("CCCC", 425,12));
        deque.add(new SuperDroid("BBBB", 41,21));
        logger.info(deque);
        logger.info(deque.peek());
        deque.poll();
        logger.info(deque);

        CustomPriorityQueue<SuperDroid> superDroids = new CustomPriorityQueue<>();
        superDroids.add(new SuperDroid("BBBB", 45,2));
        superDroids.add(new SuperDroid("AAAA", 425,12));
        superDroids.add(new SuperDroid("CCCC", 41,21));
        logger.info(superDroids);
        logger.info(superDroids.peek());

    }

}

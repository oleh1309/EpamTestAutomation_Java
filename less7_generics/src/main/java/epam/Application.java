package epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
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
    }

}

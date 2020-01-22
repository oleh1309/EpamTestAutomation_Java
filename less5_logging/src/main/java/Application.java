import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Application {

    public static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        logger.trace("the built-in TRACE level");
        logger.debug("the built-in DEBUG level");
        logger.info("the built-in INFO level");
        logger.warn("the built-in WARN level");
        logger.error("the built-in ERROR level");
        logger.fatal("the built-in FATAL level");

        ApiContextInitializer.init();

        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new Game());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Game extends TelegramLongPollingBot {

    public static final Logger logger = LogManager.getLogger(Game.class);
    public static void main(String[] args) {
        logger.trace("the built-in TRACE level");
        logger.debug("the built-in DEBUG level");
        logger.info("the built-in INFO level");
        logger.warn("the built-in WARN level");
        logger.error("the built-in ERROR level");
        logger.fatal("the built-in FATAL level");
    }

    public void onUpdateReceived(Update update) {

            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText("logger.toString()");
            try {
                execute(creatMessage(chat_id,message_text)); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

    }

    private SendMessage creatMessage(long chat_id, String text){
        String sendText = "";
        if ("ERROR".equals(text)) {
            sendText =  "the built-in ERROR level";
        }
        return new SendMessage().setChatId(chat_id).setText(sendText);
    }

    public String getBotUsername() {
         return "game1313_bot";
    }

    public String getBotToken() {
        return "945748610:AAHAjJxuxRtBVzRyknHc3--hpaquAu5R46M";
    }
}

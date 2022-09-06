import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.lang.String;
import javax.swing.*;

public class ProjectBot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new ProjectBot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);


    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message !=null && message.hasText()){
            switch (message.getText()){
                case "/help":
                    sendMessage(message, "Что надобно, кожанный ублюдок?");
                    break;
                case "/setting":
                    sendMessage(message, "Тебе что-то не нравится?");
                    break;
                default:
            //String text = message.getText();
            //if ("/help".equals(text)) {
              //  sendMessage(message, "Что надобно, кожанный ублюдок?");
            //} else if ("/setting".equals(text)) {
             //   sendMessage(message, "Тебе что-то не нравится?");
            }
        }

    }

    public String getBotUsername() {
        return "ProjectBot";
    }

    public String getBotToken() {
        return "";
    }
}

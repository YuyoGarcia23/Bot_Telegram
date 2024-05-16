package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.google.common.base.Utf8;

import es.codegym.telegrambot.TelegramBotContent;
import static es.codegym.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_3_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_4_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_5_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_6_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_7_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_8_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.FINAL_TEXT;







import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "ProyectPrimary_bot";
    public static final String TOKEN = "7117956449:AAFMOM3yXzFELeJiQz007iwHe2_AnalHyTI";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        // TODO: escribiremos la funcionalidad principal del bot aqui
    if (getMessageText().equals("/start")) {
    setUserGlory(0);    
    
    sendPhotoMessageAsync("step_1_pic");
    sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
    }

    if (getCallbackQueryButtonKey().equals("step_1_btn")) {
     setUserGlory(20);
    sendPhotoMessageAsync("step_2_pic"); 
    sendTextMessageAsync(STEP_2_TEXT,
   Map.of("¡Toma una salchicha! + 20 de fama", "step_2_btn",
            "!Tomar un pescado¡ +20 de fama", "step_2_btn",
            "!Tirar una lata de pepinillos¡ +20 de fama", "step_2_btn" ) );   
    }
    if (getCallbackQueryButtonKey().equals("step_2_btn")) {
        setUserGlory(20);
        sendPhotoMessageAsync("step_3_pic");
       sendTextMessageAsync(STEP_3_TEXT,
      Map.of("¡Rompe el robot aspirador! + 20 de fama", "step_3_btn"));
               
       }
       if (getCallbackQueryButtonKey().equals("step_3_btn")) {
        setUserGlory(30);
        sendPhotoMessageAsync("step_4_pic");
       sendTextMessageAsync(STEP_4_TEXT,
      Map.of("Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
               "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
               "Huir del robot aspirador! +30 de fama", "step_4_btn" ) ); } 

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
        
        addUserGlory(30);
        sendPhotoMessageAsync("step_5_pic");
        sendTextMessageAsync(STEP_5_TEXT, Map.of("Ponerse la GoPro +30 de fama", "step_5_btn"));   
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
           sendTextMessageAsync(STEP_6_TEXT,
          Map.of("Unos Whiskas para gatos Hackers +40 de fama", "step_6_btn",
                   "Una nueva computadora Hacker! +40 de fama", "step_6_btn",
                   "Un rascador profesional para gaticos! :o +40 de fama", "step_6_btn" ) ); 
                 } 
         if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
           sendTextMessageAsync(STEP_7_TEXT,
          Map.of("Hackear la contraseña de la computadora! +40 de fama", "step_7_btn" ) );
                 } 
         if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
           sendTextMessageAsync(STEP_8_TEXT,
          Map.of("Finalizar mision!", "step_8_btn") );
                 } 
         if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(30);
            sendPhotoMessageAsync("final_pic");
           sendTextMessageAsync(FINAL_TEXT,
          Map.of() ); } 
   /*  if  (getMessageText().contains("hola")) {
        
    
        sendTextMessageAsync("Hola\n ¿Me indicas tun *nombre* porfavor?");
        }
    if (getMessageText().contains("mi nombre es")) 
{
    sendTextMessageAsync("Encantado de conocerte\nSoy *Gato* :)");

        
    }*/
}

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
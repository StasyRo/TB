//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.io.PrintStream;
import java.util.Random;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public Bot() {
    }

    public void onUpdateReceived(Update update) {
        String Alcohol[] = new String[5];
        Alcohol = new String[]{"Водка", "Вино", "Третий шот снизу", "Третий шот сверху", "Иди домой"};
        PrintStream var10000 = System.out;
        String var10001 = update.getMessage().getFrom().getFirstName();
        var10000.println(var10001 + ": " + update.getMessage().getText());
        SendMessage sendMessage = (new SendMessage()).setChatId(update.getMessage().getChatId());
        var10001 = update.getMessage().getFrom().getFirstName();
        if(update.getMessage().getFrom().getFirstName().equals("What to drink?")) {
            Random r = new Random();
            int k = r.nextInt(5);
            sendMessage.setText("Hello" + var10001 + "\n" + Alcohol[k]);
        }
        else{
            sendMessage.setText("Please, write <What to drink?>");
        }
            try {
                this.sendMessage(sendMessage);
            } catch (TelegramApiException var4) {
                var4.printStackTrace();
            }


    }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
        return "541327707:AAGLCCMDjJFZ7Hm4rAFbtW9bxe4zfxIp1a4";
    }
}

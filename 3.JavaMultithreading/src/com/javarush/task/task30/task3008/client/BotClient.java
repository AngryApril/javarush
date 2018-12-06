package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by alexey.valiev on 11/14/18.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected String getUserName() {
        int botNumber = (int) (Math.random() * 100);
        return "date_bot_"+ botNumber;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public class BotSocketThread extends Client.SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message.split(": ").length > 1) {
                SimpleDateFormat sdp;
                switch (message.split(": ")[1]) {
                    case "дата":
                        sdp = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        sdp = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        sdp = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        sdp = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        sdp = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        sdp = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        sdp = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        sdp = new SimpleDateFormat("s");
                        break;
                    default:
                        sdp = null;
                        break;
                }
                if (sdp != null)
                    sendTextMessage("Информация для " + message.split(":")[0] + ": " + sdp.format(Calendar.getInstance().getTime()));
            }
        }
    }
}

package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by alexey.valiev on 11/13/18.
 */
public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false ;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Please enter server IP address (xxx.xxx.xxx.xxx or localhost)");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Please enter port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Please enter username");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){ return true;}

    protected SocketThread getSocketThread(){ return new SocketThread();}

    protected void sendTextMessage(String text){
        try{
            connection.send(new Message(MessageType.TEXT,text));
        }catch (IOException e){
            ConsoleHelper.writeMessage("Message wasn't sent to server");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        }
        catch (InterruptedException e) {
            ConsoleHelper.writeMessage("An exception occurred");
            return;
        }
        if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            String text = ConsoleHelper.readString();
            if (text.equals("exit")) return;
            if (shouldSendTextFromConsole()) sendTextMessage(text);
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }

        public class SocketThread extends Thread{

            protected void processIncomingMessage(String message){ ConsoleHelper.writeMessage(message); }

            protected void informAboutAddingNewUser(String userName){
                ConsoleHelper.writeMessage(userName+" has joined the conversation.");
            }

            protected void informAboutDeletingNewUser(String userName){
                ConsoleHelper.writeMessage(userName+" has left the conversation.");
            }

            protected void notifyConnectionStatusChanged(boolean clientConnected){
                Client.this.clientConnected = clientConnected;
                synchronized (Client.this){
                    Client.this.notify();
                }
            }

            protected void clientHandshake() throws IOException, ClassNotFoundException{
                while(true){
                    Message message = connection.receive();
                    if(message.getType() == MessageType.NAME_REQUEST){
                        connection.send(new Message(MessageType.USER_NAME,getUserName()));
                    }
                    else if (message.getType() == MessageType.NAME_ACCEPTED){
                        notifyConnectionStatusChanged(true); return;
                    }
                    else throw new IOException("Unexpected MessageType");
                }
            }

            protected void clientMainLoop() throws IOException, ClassNotFoundException{
                while (!isInterrupted()){
                    Message message = connection.receive();
                    if(message.getType() == MessageType.TEXT){
                        processIncomingMessage(message.getData());
                    }
                    else if (message.getType() == MessageType.USER_ADDED){
                        informAboutAddingNewUser(message.getData());
                    }
                    else if (message.getType() == MessageType.USER_REMOVED){
                        informAboutDeletingNewUser(message.getData());
                    }
                    else throw new IOException("Unexpected MessageType");
                }
            }

            public void run(){
                try{
                    String serverAddress = getServerAddress();
                    int portNumber = getServerPort();
                    Socket socket = new Socket(serverAddress,portNumber);
                    connection = new Connection(socket);
                    clientHandshake();
                    clientMainLoop();
                }catch (Exception e){
                    notifyConnectionStatusChanged(false);
                }
            }

    }
}

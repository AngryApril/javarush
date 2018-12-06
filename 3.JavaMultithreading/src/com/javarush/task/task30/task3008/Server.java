package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexey.valiev on 11/9/18.
 */
public class Server {

    private static ServerSocket serverSocket;
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException{
        ConsoleHelper.writeMessage("Please enter port number");
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is UP & Running...");
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());

        }

    }

    public static void sendBroadcastMessage(Message message){
        try{
            for(Map.Entry<String,Connection> connection : connectionMap.entrySet()){
                connection.getValue().send(message);
            }
        }catch (IOException e){
            ConsoleHelper.writeMessage("Message wasn't sent");
        }
    }

    private static class Handler extends Thread{
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String userName;
            while(true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if(message.getType() == MessageType.USER_NAME){
                    userName = message.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String,Connection> connectionEntry : connectionMap.entrySet()){
                if(!connectionEntry.getKey().equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED,connectionEntry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName+": "+message.getData()));
                }
                else ConsoleHelper.writeMessage("Message is NOT a TEXT");
            }
        }

        public void run(){
            ConsoleHelper.writeMessage("Established connection with " + socket.getRemoteSocketAddress());
            String username=null;

            try(Connection connection = new Connection(socket)){
                username = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,username));
                sendListOfUsers(connection,username);
                serverMainLoop(connection,username);
            }catch (Exception e){
                ConsoleHelper.writeMessage("Communication error");
            }
            if(username!=null){
                connectionMap.remove(username);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, username));
            }
            ConsoleHelper.writeMessage("Connection to the " + socket.getRemoteSocketAddress() + " was closed");
        }
    }
}

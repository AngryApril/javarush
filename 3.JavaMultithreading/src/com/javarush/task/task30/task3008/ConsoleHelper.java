package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alexey.valiev on 11/9/18.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() {
        String string="";

            while (string.equals("")) {
                try{
                    try {
                        string = bufferedReader.readLine();
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                        string = bufferedReader.readLine();
                    }
                }catch (IOException ie){}
            }
        
        return string;

    }

    public static int readInt(){
        int strToInt = 0;
        try{
            strToInt = Integer.parseInt(readString());
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            strToInt = Integer.parseInt(readString());
        }
        return strToInt;

    }
}

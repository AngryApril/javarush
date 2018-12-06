package com.javarush.task.task22.task2202;


/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

        if (string == null || string.isEmpty() || string.split(" ").length<5)
            throw new TooShortStringException();
        else {
            String[] s = string.split(" ");
            StringBuilder str = new StringBuilder();

            for (int i = 1; i < 5; i++) {
                str.append(s[i]);
                if (i < 4) str.append(" ");
            }
            return str.toString();
        }
        }

    public static class TooShortStringException extends RuntimeException {
    }
}

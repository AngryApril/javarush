package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        String result2 = "";
        char[] c = result.toCharArray();
        for (int i=0; i<c.length; i++){
            if (c[i] == 't' && c[i+1] == 'e') {
                result2+="??"; i++;
            }
            else result2+=c[i];
        }

        System.setOut(consoleStream);

        System.out.println(result2);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

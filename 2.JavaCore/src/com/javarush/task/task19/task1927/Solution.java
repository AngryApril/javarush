package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baout);
        PrintStream consoleStream = System.out;
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStream);

        BufferedReader reader = new BufferedReader(new StringReader(baout.toString()));

        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (++count % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

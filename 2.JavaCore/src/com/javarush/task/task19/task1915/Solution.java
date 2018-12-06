package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        PrintStream consoleStream = System.out;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream writer = new FileOutputStream(reader.readLine());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        reader.close();

        testString.printSomething();
        String result = outputStream.toString();
        for (char c : result.toCharArray()){
            writer.write(c);
        }

        writer.close();
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            reader.close();

            Solution savedObject = new Solution(4);
            Solution loadedObject;

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(name));
             outputStream.writeObject(savedObject);
            outputStream.flush();
            outputStream.close();
            System.out.println(savedObject.toString());

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(name));
            loadedObject = (Solution)inputStream.readObject();
            inputStream.close();

            System.out.println(loadedObject.toString());

            System.out.println (savedObject.string.equals(loadedObject.string));

        //System.out.println(new Solution(4));
        }
        catch (ClassNotFoundException e){}
        catch (IOException e){}
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

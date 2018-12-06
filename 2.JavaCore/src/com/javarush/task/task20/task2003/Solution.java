package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException, Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream in = new FileInputStream(name);
        load(in);
        FileOutputStream out = new FileOutputStream(name);
        save(out);

        reader.close();
        in.close();
        out.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties p = new Properties();

        for (Map.Entry<String, String> entry : properties.entrySet() ){
            p.put(entry.getKey(),entry.getValue());
        }
        p.store(outputStream, null);

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties p = new Properties();
        p.load(inputStream);
        for (Map.Entry<Object,Object> entry : p.entrySet()){
            properties.put(entry.getKey().toString(),entry.getValue().toString());
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }
}

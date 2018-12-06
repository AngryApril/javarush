package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";

        try{
            while ( true){
                s = reader.readLine();
                new FileInputStream(s).close();
            }

        }
        catch (FileNotFoundException e){
            reader.close();
            System.out.println(s);
        }


    }
}

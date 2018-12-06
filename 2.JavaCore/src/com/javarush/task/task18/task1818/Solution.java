package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fs1 = new FileOutputStream(reader.readLine());
        FileInputStream fs2 = new FileInputStream(reader.readLine());
        FileInputStream fs3 = new FileInputStream(reader.readLine());

        while (fs2.available()>0){
            fs1.write(fs2.read());
        }
        while (fs3.available()>0){
            fs1.write(fs3.read());
        }
        fs3.close();
        fs2.close();
        fs1.close();
        reader.close();
    }
}

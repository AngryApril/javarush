package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        FileInputStream in = new FileInputStream(f1);
        FileOutputStream out = new FileOutputStream(f2);
        String res = "";
        char c;

        while (in.available()>0) {
            String s = "";

            while (in.available() > 0) {
                c = (char) in.read();
                if (' ' == c) break;
                s += c;
            }

            res = Integer.toString(Math.round(Float.parseFloat(s)));
            out.write(res.getBytes());
            out.write(' ');
        }

        in.close();
        out.close();
        reader.close();
    }
}

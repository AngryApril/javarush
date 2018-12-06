package com.javarush.task.task18.task1826;


import java.io.*;
/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException,IOException{

            FileInputStream in = new FileInputStream(args[1]);
            FileOutputStream out = new FileOutputStream(args[2]);

            if (args[0].equals("-e")) {

                while (in.available() > 0) {
                    int n = 128 - in.read();
                    out.write(n);
                }
            }
            if (args[0].equals("-d")) {

                while (in.available() > 0) {
                    int n = 128 - in.read();
                    out.write(n);
                }
            }

            in.close();
            out.close();
    }

}

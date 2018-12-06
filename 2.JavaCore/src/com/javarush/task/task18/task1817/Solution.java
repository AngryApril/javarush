package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        FileInputStream fstream = new FileInputStream(args[0]);

        int p1 = 0, p2 = 0; char c;
        double p3 = 0;

        while (fstream.available() > 0){
            p1++;
            c = ((char)fstream.read());
            if (c == ' ') p2++;
        }

        p3 = 100*(double)p2/(double)p1;

        System.out.printf("%.2f",p3);
        fstream.close();
    }
}

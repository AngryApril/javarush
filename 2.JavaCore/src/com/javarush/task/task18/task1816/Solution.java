package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileInputStream fName = new FileInputStream(args[0]);
        int k=0; char c;
        while (fName.available() > 0){
            c = ((char)fName.read());
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) k++;
        }

        System.out.println(k);
        fName.close();
    }
}

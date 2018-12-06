package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> treeSet = new TreeSet<>();
        String file,file1="";
        byte[] buff;
        String endfile = "";
        FileInputStream in;

        while (!(file = reader.readLine()).equals("end")) {
            treeSet.add(file); file1 = file;
        }
        String[] name = file1.split("\\.");
        for (int i=0; i<name.length-1; i++)
        {
            if (i!=0 )endfile += "."+name[i];
            else endfile += name[i];
        }

        FileOutputStream out = new FileOutputStream(endfile);

        for (String s : treeSet){
            in = new FileInputStream(s);
            buff = new byte[in.available()];
            int n = in.read(buff);
            out.write(buff,0, n);
            in.close();
        }

        out.close();
        reader.close();
    }
}

package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader r= new BufferedReader(new FileReader(read.readLine()));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line = r.readLine())!=null){
            list.add(line.replaceAll("[^a-zA-Z^ ]",""));
        }
        int count =0;
        for(String s: list){
            for(String s1: s.split(" ")){
                if(s1.equals("world"))
                    count++;
            }
        }
        System.out.println(count);
        read.close();
        r.close();
    }
}

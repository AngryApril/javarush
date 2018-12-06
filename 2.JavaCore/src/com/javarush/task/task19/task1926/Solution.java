package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (br.ready()) {
            String reverse = new StringBuffer(br.readLine()).reverse().toString();
            list.add(reverse); }
        br.close();

        for (int n = 0; n < list.size(); n++){
            System.out.println(list.get(n));
        }
    }
}

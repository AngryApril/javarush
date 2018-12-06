package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));
        ArrayList list = new ArrayList<String>();
        String str = "";
        int k = 0;
        boolean isNumber = true;
        while ((str = br.readLine()) != null){
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++){
            String[] s = list.get(i).toString().split(" ");
            for (int j = 0; j < s.length; j++){
                try{
                    k = Integer.parseInt(s[j]);
                    isNumber = true;
                }
                catch (NumberFormatException e){
                    isNumber = false;
                }
                if (isNumber){
                    if (j>0) {bw.append(" ");}
                    bw.write(s[j]);
                }
            }
        }

        reader.close();
        br.close();
        bw.close();

    }
}

package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        while ((str = br.readLine()) != null){
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++){
            bw.write(list.get(i).toString().replaceAll("\\.","!"));
        }

        reader.close();
        br.close();
        bw.close();
    }
}

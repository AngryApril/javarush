package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.TreeMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        //reader.close();
        Map<String,Float> map = new TreeMap<>();
        float k;
        String name = "";
        while (br.ready()){
            String[] s = br.readLine().split(" ");
            name = s[0];
            k = Float.parseFloat(s[1]);
            if (map.keySet().contains(name)) {
                k+=map.get(name);
                map.put(s[0], k);
            }
            else map.put(s[0], k);
        }
        br.close();

        for (Map.Entry<String,Float> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

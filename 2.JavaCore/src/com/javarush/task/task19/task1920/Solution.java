package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        //reader.close();
        Map<String,Double> map = new TreeMap<>();
        double k, a = 0;
        String name;
        while (br.ready()){
            String[] s = br.readLine().split(" ");
            name = s[0];
            k = Double.parseDouble(s[1]);
            if (map.keySet().contains(name)) {
                k+=map.get(name);
                map.put(s[0], k);
            }
            else map.put(s[0], k);
        }
        br.close();

        for (Map.Entry<String,Double> m : map.entrySet()){
            if(a<m.getValue()) a = m.getValue();
        }

        for (Map.Entry<String,Double> m : map.entrySet()){
            if (m.getValue()==a) System.out.println(m.getKey());
        }

    }
}


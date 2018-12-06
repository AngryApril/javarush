package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws Exception {
        Map<Character,Integer> map = new TreeMap<>();
        FileInputStream fis = new FileInputStream(args[0]);

        while(fis.available()>0){
            char ch = (char) fis.read();
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else
                map.put(ch,1);
        }
        for(Map.Entry<Character,Integer> it: map.entrySet()){
            System.out.println(it.getKey() + " " + it.getValue());
        }
        fis.close();
    }
}

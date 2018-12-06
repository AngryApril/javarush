package com.javarush.task.task22.task2208;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String s, str;
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));

        BufferedWriter wr = new BufferedWriter(new FileWriter(reader.readLine()));

        while (br.ready()){
            s=""; str="";
            s+=br.readLine().split(",\"")[2];
            i = s.lastIndexOf("\"");
            str+=s.substring(0,i);
            if(!list.contains(str)) list.add(str);
        }
        br.close();

        for (String l : list){
            wr.write(l);
            wr.newLine();
        }

        wr.close();
    }
    /*
   static Map<String,String> map= new HashMap<>();

    public static void main(String[] args) {
    map.put("name","Ivanov");
      map.put("country","Ukraine");
      map.put("city","Kiev");
      map.put("age","18");
      System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String,String> pair: params.entrySet()) {
            if (pair.getValue()!=null){
                stringBuilder.append(pair.getKey() + " = '"+pair.getValue()+"' and ");
            }
        }
        int i = stringBuilder.lastIndexOf("'");
        stringBuilder.delete(i+1,stringBuilder.length());
        return stringBuilder.toString();

    }*/
}

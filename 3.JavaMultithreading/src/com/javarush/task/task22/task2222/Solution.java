package com.javarush.task.task22.task2222;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by alexey.valiev on 3/29/18.
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
}

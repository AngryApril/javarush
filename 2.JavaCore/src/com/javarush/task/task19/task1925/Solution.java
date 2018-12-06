package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        FileWriter wr = new FileWriter(args[1]);
        //reader.close();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        while (br.ready()){
            list.add(br.readLine());
        }
        br.close();

        for (int n = 0; n < list.size(); n++){
            String[] word = list.get(n).split(" ");
            for (int i = 0; i < word.length; i++){
                if(word[i].length()>6) words.add(word[i]);
            }
        }

        for (int i = 0; i < words.size(); i++){
            wr.write(words.get(i));
            if (i<words.size()-1) wr.write(",");
        }
        wr.close();
    }
}

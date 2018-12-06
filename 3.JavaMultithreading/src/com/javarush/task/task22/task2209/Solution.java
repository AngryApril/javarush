package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader(reader.readLine()))) {
            String s = "";
            while (br.ready()) {
                s += br.readLine();
                s += " ";
            }
            String[] words = s.split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
            reader.close();
            br.close();
        }
        catch (IOException e){
            System.out.println("File Not Found");
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();

        if (words == null || words.length == 0) return stringBuilder;
        else {
            ArrayList<String> w = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                w.add(words[i]);
            }
            String s = w.get(new Random().nextInt(w.size() - 1));
            stringBuilder.append(s);
            w.remove(s);
            int k;

            while ((k=w.size()) > 0) {

                for (int j = 0; j < w.size(); j++) {
                    if (w.get(j).toLowerCase().charAt(0) == stringBuilder.toString().toLowerCase().charAt(stringBuilder.length() - 1)) {
                        stringBuilder.append(" ");
                        stringBuilder.append(w.get(j));
                        w.remove(j);
                        j--;
                    }
                }
                if(k == w.size()) {
                    s = w.get(0);
                    stringBuilder.append(" ");
                    stringBuilder.append(s);
                    w.remove(s);
                }
            }

            return stringBuilder;
        }
    }
}

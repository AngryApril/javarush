package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] tokens = getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < tokens.length; i++){
            if (i>0) System.out.print(" ");
            System.out.print(tokens[i]);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] tokens = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()){
            tokens[i] = stringTokenizer.nextToken();
            i++;
        }
        return tokens;
    }
}

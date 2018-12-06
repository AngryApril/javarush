package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        int length = substring.length();

        for (int i = 0; i <= max; i++) {
            int k=i;
            for(int j=0; j<length; j++){
                if (string.charAt(k)==substring.charAt(j)){
                    if(j==length-1) {
                        System.out.println("i="+i + " k="+k+ " j="+ j +" found=true");
                        found = true;
                    }
                    k++;
                }
                else { j=length; System.out.println("i="+i + " k="+k+ " j="+ j +" found!=true");}
            }
        }
        return found;
    }
}


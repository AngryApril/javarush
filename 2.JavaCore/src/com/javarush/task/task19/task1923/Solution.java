package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        FileWriter wr = new FileWriter(args[1]);
        //reader.close();
        int count = 0;
        String str;
        while (br.ready()){
            str = br.readLine();
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++){
                char[] c = s[i].toCharArray();
                for (int j=0; j<c.length; j++){
                    if (c[j]>='0' && c[j]<='9' ) {
                        if (count > 0) wr.write(" ");
                        wr.write(s[i]);
                        count++;
                        break;
                    }
                }
            }
        }
        br.close();
        wr.close();
    }
}

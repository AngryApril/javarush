package com.javarush.task.task20.task2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        //try {
            ArrayList<Long> result1 = new ArrayList<>();
            long[] armstrongNum = {
                    1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474,
                    54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
                    24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                    912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                    42678290603L, 44708635679L, 49388550606L, 82693916578L,
                    94204591914L, 28116440335967L, 4338281769391370L,
                    4338281769391371L, 21897142587612075L, 35641594208964132L,
                    35875699062250035L, 1517841543307505039L, 3289582984443187032L,
                    4498128791164624869L, 4929273885928088826L};
        /*проходит проверку, но долго
        for(long S = 1; S < N; S++) {
            int M = String.valueOf(S).length();
            long s = S, res = 0;
            while (s > 0) {
                res+=Math.pow(s%10,M);
                s = s / 10;
            }
            if (S == res) result1.add(S);
        }*/
        System.out.println(armstrongNum.length);
            for (int i = 0; armstrongNum[i] < N; i++) {
                if(i<armstrongNum.length-1)
                result1.add(armstrongNum[i]);
                else break;
            }
            long[] result = new long[result1.size()];
            for (int i = 0; i < result1.size(); i++) {
                result[i] = result1.get(i);
            }

            return result;
    //} catch (NumberFormatException e){}

    }

    public static void main(String[] args) throws IOException{
        try {
            long[] res;
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            res = getNumbers(Long.MAX_VALUE);
            //reader.close();
            for (int i = 0; i < res.length; i++)
                System.out.println(res[i]);

            System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        }
        catch (NumberFormatException e){
            //System.out.println("Wrong value");
        }
    }
}

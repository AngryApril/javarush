package com.javarush.task.task26.task2601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) throws IOException{
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string1 = reader.readLine();
        String[] strArray = string1.split(", ");
        Integer[] array = new Integer[strArray.length];
        for (int i=0; i<strArray.length; i++){
            array[i] = Integer.parseInt(strArray[i]);
        }

        sort(array);
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if (i< array.length-1) System.out.print(", ");
        }*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        final double median;
        if (len % 2 != 0) median = array[len / 2];
        else median = (double) (array[len / 2 - 1] + array[len / 2]) / 2;

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double res = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (res == 0) return o1 - o2;
                else return (int) res;
            }
        });

        return array;

    }
}

package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fis = new FileInputStream(file);
        Scanner sc = new Scanner(fis);
        int productId = Integer.parseInt(args[0]);

        while (sc.hasNextLine()){
            String[] product = sc.nextLine().split(" ");

            if (Integer.parseInt(product[0]) == productId){ // проверка на совпадение id
                System.out.println(product[0] + " " + product[1] + " " + product[2] + " " + product[3]);
                //break;
            }
        }

        fis.close();
        reader.close();
    }
}

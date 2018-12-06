package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> lists = new ArrayList<>();
        while ((line = fileReader.readLine()) != null){
            lists.add(line);
        }
        fileReader.close();

        String str = reader.readLine();
        reader.close();
        String[] param = str.split(" ");
        if (param[0].equals("-c")){

            long maxID = Integer.MIN_VALUE;

            for (String s: lists){
                int idName = Integer.parseInt(s.substring(0,8).trim());
                if (idName > maxID) maxID = idName;
            }
            String id = String.valueOf(++maxID).concat("        ").substring(0,8);
            String productName = "";
            for (int j = 1; j < param.length - 2; j++){
                if (j>1) {productName += " "; }
                productName = productName.concat(param[j]);
            }
            productName = productName.concat("                              ").substring(0,30);
            String price = param[param.length - 2].concat("        ").substring(0,8);
            String quantity = param[param.length - 1].concat("    ").substring(0,4);
            String result = id.concat(productName.concat(price.concat(quantity)));
            lists.add(result);


            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: lists){
                fileWriter.write(s);
                fileWriter.newLine();
            }
            fileWriter.close();
        }
    }
}

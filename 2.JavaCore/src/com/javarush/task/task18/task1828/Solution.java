package com.javarush.task.task18.task1828;

/* 
Прайсы 2
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

        int k = 0;
        String str = reader.readLine();
        reader.close();
        String[] param = str.split(" ");
        if (param[0].equals("-u")){

            int ID = Integer.parseInt(param[1]);
            for (String s: lists){
                int idName = Integer.parseInt(s.substring(0,8).trim());
                if (idName == ID) k = lists.indexOf(s);
            }
            String id = String.valueOf(ID).concat("        ").substring(0,8);
            String productName = "";
            for (int j = 2; j < param.length - 2; j++){
                if (j>2) {productName += " "; }
                productName = productName.concat(param[j]);
            }
            productName = productName.concat("                              ").substring(0,30);
            String price = param[param.length - 2].concat("        ").substring(0,8);
            String quantity = param[param.length - 1].concat("    ").substring(0,4);
            String result = id.concat(productName.concat(price.concat(quantity)));
            lists.remove(k);
            lists.add(k,result);

        }

        if (args[0].equals("-d")){

            int ID = Integer.parseInt(param[1]);
            for (String s: lists){
                int idName = Integer.parseInt(s.substring(0,8).trim());
                if (idName == ID) k = lists.indexOf(s);
            }
            lists.remove(k);
        }
        //for (String s: lists){ System.out.println(s); }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: lists){
                fileWriter.write(s);
                fileWriter.newLine();
            }
            fileWriter.close();

    }
}

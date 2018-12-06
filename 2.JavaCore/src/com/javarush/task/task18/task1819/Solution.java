package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fs1 = new FileInputStream(file1);
        byte[] tmp = new byte[fs1.available()];

        while (fs1.available()>0){  fs1.read(tmp);  }

        reader.close();
        fs1.close();

        FileInputStream fs2 = new FileInputStream(file2);
        FileOutputStream raf1 = new FileOutputStream(file1, true);

        while (fs2.available()>0){  raf1.write(fs2.read());  }
        raf1.write(tmp);

        fs2.close();
        raf1.close();

    }
}

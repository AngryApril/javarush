package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static final  Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        boolean flow = true;
        while (flow){
            file = reader.readLine();
            if (file.equals("exit")) {flow = false;}
            else new ReadThread(file).start();
        }
        for (Map.Entry r : resultMap.entrySet()){
            System.out.println(r.getKey() + " " + r.getValue());
        }
        reader.close();
    }

    public static class ReadThread extends Thread{

        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {

            try {
                int max, k = 0;
                int[] bytes = new int[256];

                FileInputStream fis = new FileInputStream(fileName);

                while (fis.available() > 0) {
                    bytes[fis.read()]++;
                }
                max = bytes[0];
                for (int i = 0; i < bytes.length; i++){
                    if (bytes[i] > max) { max = bytes[i]; k = i; }
                }

                synchronized (Solution.resultMap) {
                    Solution.resultMap.put(fileName,k);
                }

                fis.close();
            }
            catch (IOException e){}

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}

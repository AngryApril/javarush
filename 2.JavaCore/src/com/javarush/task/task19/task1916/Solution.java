package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> lines1 = new ArrayList<String>();
    public static List<String> lines2 = new ArrayList<String>();


    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader r1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader r2 = new BufferedReader(new FileReader(reader.readLine()));
        //BufferedWriter r3 = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        while (r1.ready()) { lines1.add(r1.readLine()); }
        while (r2.ready()) { lines2.add(r2.readLine());}
        r1.close();
        r2.close();

        while (lines1.size()>lines2.size()) { lines2.add(""); }
        while (lines1.size()<lines2.size()) { lines1.add(""); }

        int j=0;
            for (int i = 0; i < lines1.size();  i++) {
                if (lines1.get(i).isEmpty() && !lines2.get(j).isEmpty()) {
                    lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                    j++;
                }
                else if (!lines1.get(i).isEmpty() && lines2.get(j).isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                    j++;
                }
                else
                if (lines1.get(i).equals(lines2.get(j))) {
                    lines.add(new LineItem(Type.SAME, lines1.get(i)));
                    j++;
                }
                else if (lines1.get(i).equals(lines2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                    i--; j++;
                } else lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
            }


        /*ДЛЯ СЕБЯ: ПРОВЕРКА ЗАПИСЬЮ В ФАЙЛ
        for (int i=0; i<lines.size(); i++){
            r3.write(lines.get(i).type.toString() + " " + lines.get(i).line);
            if (i!=lines.size()-1) r3.newLine();
        }
        r3.close();*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

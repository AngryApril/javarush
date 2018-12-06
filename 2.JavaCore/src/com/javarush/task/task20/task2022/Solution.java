package com.javarush.task.task20.task2022;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution() {
    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception{

        /*Solution solution = new Solution("111");
        FileOutputStream fos = solution.stream;
        ObjectOutputStream out = new ObjectOutputStream(fos);
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        TreeMap<Integer, String> map2 = new TreeMap<Integer, String>();
        map.put(1,"User001"); map.put(2,"User002"); map.put(3,"User003");
        map2.put(5,"User005"); map2.put(6,"User006"); map2.put(7,"User007");
        MyTable myTable = new MyTable(map);

        solution.writeObject(out);
        out.writeObject(myTable);

        out.flush();
        out.close();*/

    }

}

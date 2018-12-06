package com.javarush.task.task20.task2022;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by alexey.valiev on 1/3/18.
 */
public class MyTable extends Solution implements Serializable{
    private TreeMap<Integer,String> map;

    public MyTable() {}

    public MyTable(TreeMap<Integer, String> map) {
        this.map = map;
    }
}

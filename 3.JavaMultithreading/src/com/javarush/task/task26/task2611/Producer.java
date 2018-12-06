package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexey.valiev on 11/8/18.
 */
public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map){
        this.map = map;
    }

    @Override
    public void run() {
        try{
            int i=0;
            Thread currentThread = new Thread();
            while(!currentThread.isInterrupted()){
                i++;
                map.put(String.valueOf(i),"Some text for "+i);
                Thread.sleep(500);
            }

            }
        catch (Exception e){
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}

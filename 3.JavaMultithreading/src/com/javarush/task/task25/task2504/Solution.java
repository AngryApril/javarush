package com.javarush.task.task25.task2504;

import java.util.List;

/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (int i=0; i<threads.length; i++){
            Thread thread = threads[i];
            switch (thread.getState()){
                case NEW: thread.start(); break;
                case RUNNABLE: thread.isInterrupted(); break;
                case BLOCKED: thread.interrupt(); break;
                case WAITING: thread.interrupt(); break;
                case TIMED_WAITING: thread.interrupt(); break;
                case TERMINATED: System.out.println(thread.getPriority()); break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Thread[] threads = new Thread[6];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread();
               // threads[i].setPriority(threads.length-i);
            }
            threads[0].start();
            threads[1].run();
            threads[2].join();
            threads[3].isInterrupted();
            threads[4].start();
            threads[4].isInterrupted();
            threads[5].run();
            processThreads(threads);
//            threads[2].notifyAll();
        }catch (InterruptedException e){  }

    }
}

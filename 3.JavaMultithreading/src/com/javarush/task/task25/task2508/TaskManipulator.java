package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {

    private Thread t;

    public TaskManipulator() {
    }

    @Override
    public void run() {
        try {
            while(!t.isInterrupted()) {
                if (t.getState() == Thread.State.RUNNABLE) {
                    System.out.println(t.getName());
                }
                Thread.sleep(100);
            }
        }catch(InterruptedException e){ Thread.interrupted();}
    }

    @Override
    public void start(String threadName) {
        t = new Thread(this);
        t.setName(threadName);
        t.start();
    }

    @Override
    public void stop() {
        if(!t.isInterrupted()) t.interrupt();
    }


}

package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception ignored) {
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1,o2);
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception ignored) {
                    }
                }
            }
        };

        try {
            t1.setDaemon(true);
            t2.setDaemon(true);
            t3.setDaemon(true);
            t1.start();
            System.out.println("Thread-1 "+t1.getState());
            System.out.println("Thread-2 "+t2.getState());
            Thread.sleep(50);
            System.out.println("Thread-1 "+t1.getState());
            System.out.println("Thread-2 "+t2.getState());
            t2.start();
            Thread.sleep(50);
            t3.start();
            System.out.println("Thread-1 "+t1.getState());
            System.out.println("Thread-2 "+t2.getState());
            System.out.println("Thread-3 "+t3.getState());
            Thread.sleep(50);
        }
        catch (Exception ignored) {
        }
        while (true) {
            if (t3.getState().equals(Thread.State.BLOCKED)) {
                System.out.println("Thread-1 "+t1.getState());
                System.out.println("Thread-2 "+t2.getState());
                System.out.println("Thread-3 "+t3.getState());
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                return false;
            }
            else if (!t3.getState().equals(Thread.State.BLOCKED) ) {
                System.out.println("Thread-1 "+t1.getState());
                System.out.println("Thread-2 "+t2.getState());
                System.out.println("Thread-3 "+t3.getState());
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
                return true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}

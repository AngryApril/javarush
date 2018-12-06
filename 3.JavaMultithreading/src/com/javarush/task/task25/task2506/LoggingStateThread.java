package com.javarush.task.task25.task2506;

/**
 * Created by alexey.valiev on 10/29/18.
 */
public class LoggingStateThread extends Thread {
    Thread targetThread = new Thread();

    public LoggingStateThread() {
    }

    public LoggingStateThread(Thread target) {
        super(target);
        this.targetThread = target;

    }

    @Override
    public void run() {

            State state, lastState = null;
            do {
                state = targetThread.getState();
                if (state != lastState) {
                    System.out.println(state);
                    lastState = state;
                }
            } while (state != State.TERMINATED);

    }
}

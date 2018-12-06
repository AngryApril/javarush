package com.javarush.task.task29.task2909.car;

/**
 * Created by alexey.valiev on 11/2/18.
 */
public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;

        return MAX_SEDAN_SPEED;
    }
}

package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() { return horses; }

    public void run() throws InterruptedException{
        for(int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(100);
            if (i == 2) System.out.println("- Старт.");
            if (i == 12) System.out.println("- Слевин вырывается вперед.");
            if (i == 22) System.out.println("- 10 баксов на Слевина.");
            if (i == 32) System.out.println("- Гомер уверенно вырывается вперед.");
            Thread.sleep(100);
            if (i == 7) System.out.println("- Гомер неожиданно обходит Лаки.");
            if (i == 17) System.out.println("- Вперед Лаки!");
            if (i == 27) System.out.println("- Похоже Лаки сбросил жокея и расслабился.");
            if (i == 99) System.out.println("- Неожиданно для всех побеждает Гомер. Вот это номер!");
        }
    }
    public void move(){
        for (Horse h: horses) h.move();

    }
    public void print(){
        for (Horse h: horses) h.print();
        for (int i = 0; i < 10; i++) System.out.println();
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);
        for(Horse horse: horses) {
            if (winner.getDistance() < horse.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException{
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Sleven",3.0,0.0));
        horses.add(new Horse("Lucky",3.0,0.0));
        horses.add(new Horse("Gomer",3.0,0.0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}

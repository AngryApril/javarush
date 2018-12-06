package com.javarush.task.task19.task1904;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws FileNotFoundException{

        FileInputStream in = new FileInputStream("6.txt");

        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(in));

        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read(){
            String s = fileScanner.nextLine();
            String[] p = s.split(" ");

            Calendar birthDate = new GregorianCalendar(Integer.parseInt(p[5]), Integer.parseInt(p[4])-1, Integer.parseInt(p[3]));

            //System.out.println(p[1] +" "+ p[2]+" "+ p[0]+ " " + birthDate.getTime());
            return new Person(p[1],p[2],p[0],birthDate.getTime());}

        public void close(){ fileScanner.close();}
    }
}

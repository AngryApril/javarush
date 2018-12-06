package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        //reader.close();
        String str, name;

        while (br.ready()){
            str = br.readLine();
            String[] p = str.split(" ");
            name="";
            for (int i = 0; i < p.length-3; i++){
                if (i>0) name+= " ";
                name+= p[i];
            }

            Calendar birthDate =
                    new GregorianCalendar(Integer.parseInt(p[p.length-1]),
                            Integer.parseInt(p[p.length-2])-1,
                            Integer.parseInt(p[p.length-3]));
            PEOPLE.add(new Person(name, birthDate.getTime()));
            System.out.println(name + " " + birthDate.getTime());
        }

        br.close();
    }
}

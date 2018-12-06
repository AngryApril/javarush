package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{
        private Contact contact;
        private Customer customer;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode(){
            String gCC = "";
            for (Map.Entry m : countries.entrySet()){
                if (m.getValue().equals(this.customer.getCountryName()))
                    gCC = m.getKey().toString();
            }
            return gCC;}

        public String getCompany(){return this.customer.getCompanyName();}            //example JavaRush Ltd.

        public String getContactFirstName(){
            String[] str = this.contact.getName().split(" ");
            return str[1];}   //example Ivan

        public String getContactLastName(){
            String[] str = this.contact.getName().split(",");
            return str[0];
        }    //example Ivanov
        public String getDialString(){
            String pN = this.contact.getPhoneNumber();
           // char[] chars = new char[pN.length()];
            char[] chars = pN.toCharArray();
            pN = "";
            for (char c : chars){
                if (c != '(' && c != ')' && c != '-') pN += c;
            }
            return "callto://" + pN;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
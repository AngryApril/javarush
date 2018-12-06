package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        public String getCompanyName(){ return this.data.getCompany();}        //example JavaRush Ltd.

        public String getCountryName(){ return countries.get(this.data.getCountryCode());}

        public String getName(){ return this.data.getContactLastName() + ", " + this.data.getContactFirstName(); }               //example Ivanov, Ivan

        public String getPhoneNumber(){
            String phoneCode = String.valueOf(this.data.getCountryPhoneCode());
            String phoneNumber = String.valueOf(this.data.getPhoneNumber());
            while (phoneNumber.length()<10){phoneNumber = "0" + phoneNumber; }
                return "+" + phoneCode + "(" + phoneNumber.substring(0,3) + ")"
                        + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,8) + "-" + phoneNumber.substring(8);
            //} else return phoneCode+phoneNumber;
        }

    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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
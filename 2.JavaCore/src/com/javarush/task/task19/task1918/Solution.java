package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        /*ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(reader.readLine()));
        String tag = args[0];
        reader.close();
        String str = "";
        String btag = "<"+tag;
        String etag = "</"+tag;
        while (br.ready()){
            str+=br.readLine();
        }
        String string = str.replaceAll("\r\n", "");
        br.close();
        ArrayList<Integer> bIxes = new ArrayList<>();
        ArrayList<Integer> eIxes = new ArrayList<>();
        int fIx = string.indexOf(btag), n, i =0;
        bIxes.add(fIx);
        while (fIx<=string.lastIndexOf(btag)){
            n = string.indexOf(btag,fIx);
            if (n!=bIxes.get(i)) {
                bIxes.add(n);
                i++;
            }
            else fIx++;
        }
        fIx = string.indexOf(etag);
        i = 0;
        eIxes.add(fIx);
        while (fIx<=string.lastIndexOf(etag)){
            n = string.indexOf(etag,fIx);
            if (n!=eIxes.get(i)) {
                eIxes.add(n);
                i++;
            }
            else fIx++;
        }

        for (i = 0; i < bIxes.size(); i++){
            if (i<bIxes.size()-1){
                if(bIxes.get(i+1)>eIxes.get(i))
                    list.add(string.substring(bIxes.get(i),eIxes.get(i)+7));
                else {
                    list.add(string.substring(bIxes.get(i),eIxes.get(i+1)+7));
                    list.add(string.substring(bIxes.get(i+1),eIxes.get(i)+7));
                    i++;
                }
            }
            else list.add(string.substring(bIxes.get(i),eIxes.get(i)+7));
        }
        for (String s : list){
            System.out.println(s);
        }*/

        //for (i = 0; i < bIxes.size(); i++){ System.out.println(bIxes.get(i)); }
        //for (i = 0; i < eIxes.size(); i++){ System.out.println(eIxes.get(i)); }
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        conReader.close();

        //Read File
        BufferedReader fileBufReader = new BufferedReader(new FileReader(fileName));
        StringBuffer content = new StringBuffer();
        while (fileBufReader.ready())
            content.append(fileBufReader.readLine());
        fileBufReader.close();
        StringBuffer text = new StringBuffer(content.toString().replaceAll("\r\n", ""));

        String tagOpen = "<" + args[0];
        String tagClose = "</" + args[0] + ">";

        int pozitionOpen = -1;
        int pozitionClose = -1;
        int shift = -1;
        Stack<Integer> openedTags = new Stack<>();
        Map<Integer, Integer> tags = new TreeMap<>(new MyComparator());
        while (true) {
            pozitionOpen = text.indexOf(tagOpen, shift);
            pozitionClose = text.indexOf(tagClose, shift);
            if (pozitionOpen < 0 && pozitionClose < 0)
                break;

            if (pozitionOpen != -1 && pozitionOpen < pozitionClose) { //Open ближе чем close
                openedTags.push(pozitionOpen);
                shift = pozitionOpen + tagOpen.length();
                continue;
            }

            if (pozitionClose != -1 && (pozitionOpen > pozitionClose || pozitionOpen == -1)) { //Close ближе чем open
                if (openedTags.isEmpty())
                    break;
                tags.put(openedTags.pop(), pozitionClose + tagClose.length());
                shift = pozitionClose + tagClose.length();
            }
        }

        for (Map.Entry<Integer, Integer> pair : tags.entrySet()) {
            System.out.println(text.substring(pair.getKey(), pair.getValue()));
        }
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }
}

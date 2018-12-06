package com.javarush.task.task18.task1813;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    private FileOutputStream ori;

    public AmigoOutputStream(FileOutputStream ori) throws IOException {
        super(ori.getFD());
        this.ori = ori;
    }

    public void flush() throws IOException {ori.flush();}

    public void write(int b) throws IOException{ori.write(b);}

    public void write(byte[] b) throws IOException{ori.write(b);}

    public void write(byte[] b, int off, int len) throws IOException{ori.write(b, off, len);}

    public void close() throws IOException{
        ori.flush();
        ori.write("JavaRush © All rights reserved.".getBytes());
        ori.close();
    }


    public static String fileName = "1.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }




}

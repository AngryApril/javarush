package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.Command;
import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

/**
 * Created by alexey.valiev on 11/27/18.
 */
public class Archiver {

    public static void main(String[] args){
        try{
            ConsoleHelper.writeMessage("Write full path to the new archive");
            String archivePath = ConsoleHelper.readString();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));

            ConsoleHelper.writeMessage("Enter full path to the file that will be archived");
            String filePath = ConsoleHelper.readString();
            zipFileManager.createZip(Paths.get(filePath));
            new ExitCommand().execute();
        }catch(Exception e){}
    }
}

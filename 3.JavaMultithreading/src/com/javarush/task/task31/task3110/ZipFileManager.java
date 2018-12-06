package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.*;

/**
 * Created by alexey.valiev on 11/27/18.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bytes = new byte[1000];
            try(InputStream inputStream = Files.newInputStream(source)) {

                while (inputStream.available() > 0) {
                    int intbuf = inputStream.read(bytes);
                    zipOutputStream.write(bytes,0,intbuf);
                }
                inputStream.close();
            }
            zipOutputStream.close();
        }

    }
}

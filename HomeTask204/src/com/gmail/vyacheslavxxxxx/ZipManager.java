package com.gmail.vyacheslavxxxxx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipManager {
    private static String zipPath = "./source.zip";

    public static void main(String[] args) {
        Group group = new Group(123);

        group.addStudent(new Student("Kain", 14));
        group.addStudent(new Student("Ivan", 13));
        group.addStudent(new Student("Eren", 11));

        saveToZip(group, zipPath);
        System.out.println(readFromZip(zipPath));
    }

    public static void saveToZip(Group group, String path) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(path))) {
            ZipEntry zipEntry = new ZipEntry("source.dat");
            byte[] buffer = group.toString().getBytes();
            zipOut.putNextEntry(zipEntry);
            zipOut.write(buffer, 0, buffer.length);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static String readFromZip(String path) {
        StringBuilder sb = new StringBuilder();
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(path))) {
            ZipEntry entry = zipIn.getNextEntry();
            byte[] buffer = new byte[1024];
            int bytesRead; 
            if (entry != null) {
                while ((bytesRead = zipIn.read(buffer)) >= 0) {
                    sb.append(new String(buffer, "UTF-8"));
                }
                zipIn.closeEntry();
            }

        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return sb.toString();
    }
}

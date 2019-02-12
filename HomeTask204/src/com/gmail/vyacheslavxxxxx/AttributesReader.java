package com.gmail.vyacheslavxxxxx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class AttributesReader {
    public static void main(String[] args) { 
        System.out.println(getAttribut("./src/com/gmail/vyacheslavxxxxx/AttributesReader.java"));
    }

    private static String getAttribut(String fName) {
        Path path = Paths.get(fName);
        try {
            DosFileAttributes attr = Files.readAttributes(path, DosFileAttributes.class);
            return readAttr(attr);

        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return "";
    }

    private static String readAttr(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-20s %s %n", "Type:", getType(attr)));
        sb.append(String.format("%-20s %.3f K %n", "Size:", convertByteToKByte(attr.size())));
        sb.append(String.format("%-20s %s %n", "Text:", getAddAttr(attr)));

        sb.append(String.format("%-20s %s %n", "Create:", attr.creationTime()));
        sb.append(String.format("%-20s %s %n", "Last access:", attr.lastAccessTime()));
        sb.append(String.format("%-20s %s %n", "Last modification:", attr.lastModifiedTime()));

        return sb.toString();
    }

    private static double convertByteToKByte(long bytes) {
        return bytes / 1024.0;
    }

    private static String getAddAttr(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();

        sb.append(attr.isHidden() ? "hidden|" : "not hidden|");
        sb.append(attr.isReadOnly() ? "readonly|" : "not read only|");
        sb.append(attr.isSystem() ? "system|" : "not system|");
        sb.append(attr.isArchive() ? "archive|" : "not archive|");

        return sb.toString();
    }

    private static String getType(DosFileAttributes attr) {
        StringBuilder sb = new StringBuilder();
        sb.append(attr.isDirectory() ? "Directory" : "File");
        return sb.toString();
    }
}
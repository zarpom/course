package com.gmail.vyacheslavxxxxx;

import java.io.*;
import java.util.Arrays;

public class FileC {

    public static void main(String[] args) {
        System.out.println("---------Copy files---------\n");
        mkDir("./dir");
        copyFiles("./temp", "./dir", new String[] { "1231" });
        delDir("./temp", new String[] { "1231" });
    }

    private static void mkDir(String path) {
        File file = new File(path);
        file.mkdir();
    }

    private static void copyFiles(String sourcePath, String secondPath, String[] filesNames) {
        File file;
        try {
            for (String fName : filesNames) {
                file = new File(secondPath + "/" + fName);
                file.createNewFile();
                copyContent(sourcePath + "/" + fName, secondPath + "/" + fName);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void delDir(String sourcePath, String[] filesNames) {

        File file;

        for (String fName : filesNames) {
            file = new File(sourcePath + "/" + fName);
            file.delete();
        }

        file = new File(sourcePath);

        if (!file.delete())
            System.out.println("Couldn't remove dir \"" + sourcePath + "\"");
    }

    private static void copyContent(String pathFrom, String pathTo) throws IOException {

        byte[] buffer = new byte[1024];
        int length;

        DataInputStream in = new DataInputStream(new FileInputStream(pathFrom));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(pathTo));

        while ((length = in.read(buffer)) >= 0) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
    }
}
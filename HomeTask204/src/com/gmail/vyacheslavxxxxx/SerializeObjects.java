package com.gmail.vyacheslavxxxxx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObjects {
    private static Group group;
    private static Student st;
    private static String serGroup = "./group.dat";
    private static String serStudent = "./student.dat";

    public static void main(String[] args) {
        initGroup();
        serialize();
        deserialize();
    }

    private static void initGroup() {
        group = new Group(3);
        st = new Student("Kira", 18);

        group.addStudent(new Student("Lena", 14));
        group.addStudent(new Student("Katya", 16));
        group.addStudent(st);
    }
    @SuppressWarnings("resource")
    private static void serialize() {
        try {
            ObjectOutputStream outGroup = new ObjectOutputStream(new FileOutputStream(serGroup));
    
            ObjectOutputStream outStudent = new ObjectOutputStream(new FileOutputStream(serStudent));

            outGroup.writeObject(group);
            outStudent.writeObject(st);

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    @SuppressWarnings("resource")
    private static void deserialize() {
        Student st;
        Group gr;
        try {
            ObjectInputStream inGroup = new ObjectInputStream(new FileInputStream(serGroup));
            ObjectInputStream inStudent = new ObjectInputStream(new FileInputStream(serStudent));

            st = (Student) inStudent.readObject();
            gr = (Group) inGroup.readObject();

            System.out.println(st);
            System.out.println(gr);
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}
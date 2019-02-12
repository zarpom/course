package com.gmail.vyacheacheslavxxxxx;

import java.util.HashSet;
import java.util.Set;

import com.gmail.vyacheacheslavxxxxx.Trip.TransportAreaException;

public class Main {
    public static void main(String[] args) {
        RailwayStation khaUjn = new RailwayStation("Харьков южн.");
        RailwayStation novoUjn = new RailwayStation("Новоселовка южн");
        RailwayStation limanDon = new RailwayStation("Лиман Дон");
        RailwayStation lubUjn = new RailwayStation("Люботин южн");
        RailwayStation bogodUjn = new RailwayStation("Богодухов южн");
        RailwayStation merefaUjn = new RailwayStation("Мерефа южн");
        RailwayStation lozUjn = new RailwayStation("Лозовая южн");
        RailwayStation poltUjn = new RailwayStation("Полтава южн");
        RailwayStation krasnoUjn = new RailwayStation("Красноград южн");
        RailwayStation zashepPridn = new RailwayStation("Зачепиловка придн");

        Trip<RailwayStation> line1 = null;
        Trip<RailwayStation> line2 = null;
        Trip<RailwayStation> line3 = null;
        Trip<RailwayStation> line4 = null;
        Trip<RailwayStation> line5 = null;
        Trip<RailwayStation> line6 = null;
        Trip<RailwayStation> line7 = null;
        Trip<RailwayStation> line8 = null;
        Trip<RailwayStation> line9 = null;
        Trip<RailwayStation> line10 = null;
        Trip<RailwayStation> line11 = null;
        Trip<RailwayStation> line12 = null;
        Trip<RailwayStation> line13 = null;

        try {
            line1 = new Trip<>(2, 5, khaUjn, novoUjn);
            line2 = new Trip<>(183, 180, novoUjn, limanDon);
            line3 = new Trip<>(23, 30, novoUjn, merefaUjn);
            line4 = new Trip<>(22, 30, novoUjn, lubUjn);
            line5 = new Trip<>(53, 60, bogodUjn, lubUjn);
            line6 = new Trip<>(18, 30, lubUjn, merefaUjn);
            line7 = new Trip<>(116, 60, lubUjn, poltUjn);
            line8 = new Trip<>(76, 60, merefaUjn, krasnoUjn);
            line9 = new Trip<>(123, 60, merefaUjn, lozUjn);
            line10 = new Trip<>(81, 80, poltUjn, krasnoUjn);
            line11 = new Trip<>(28, 40, krasnoUjn, zashepPridn);
            line12 = new Trip<>(95, 80, krasnoUjn, lozUjn);
            line13 = new Trip<>(132, 150, krasnoUjn, zashepPridn);

        } catch (TransportAreaException e1) {
            e1.printStackTrace();
        }

        Set<Trip> transportAreas = new HashSet<>();
        transportAreas.add(line1);
        transportAreas.add(line2);
        transportAreas.add(line3);
        transportAreas.add(line4);
        transportAreas.add(line5);
        transportAreas.add(line6);
        transportAreas.add(line7);
        transportAreas.add(line8);
        transportAreas.add(line9);
        transportAreas.add(line10);
        transportAreas.add(line11);
        transportAreas.add(line12);
        transportAreas.add(line13);

        TransportSystem<RailwayStation> transportSystem = new TransportSystem<>();
        transportSystem.setTransportAreas(transportAreas);

        for (RailwayStation edge : transportSystem.getEdges()) {
            System.out.println(edge);
        }
        System.out.println("_________ALL_____________");
        for (RailwayStation edge : transportSystem.getAllNearEdges(khaUjn)) {
            System.out.println(edge);
        }
        System.out.println("________SORT___________");
        for (RailwayStation edge : transportSystem.sortingByNearEdges()) {
            System.out.println(edge);
        }

        System.out.println("________Все линии___________");
        for (Trip line : transportAreas) {
            System.out.println(line);
        }
         
        System.out.println("_______SPEED____________");
        System.out.println(transportSystem.getHightSpeedLine());
        
    }
}

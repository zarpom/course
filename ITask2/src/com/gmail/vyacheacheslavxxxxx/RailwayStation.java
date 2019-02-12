package com.gmail.vyacheacheslavxxxxx;

public class RailwayStation {
    private String name;

    public RailwayStation() {
        super();
    }

    public RailwayStation(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RailwayStation [name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RailwayStation railwayStation = (RailwayStation) obj;
        if (!railwayStation.name.equals(this.name)) {
            return false;
        }
        return true;
    }
}

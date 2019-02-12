package com.gmail.vyacheacheslavxxxxx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
 
public class TransportSystem<T> {
    private Set<Trip> transportAreas;

    Set<T> getEdges() {
        Set<T> edges = new HashSet<>();
        for (Trip<T> line : this.transportAreas) {
            edges.add(line.getFirstEndPoint());
            edges.add(line.getSecondEndPoint());
        }
        return edges;
    }

    public Trip getHightSpeedLine() {
        double max = -1;
        Trip<T> maxLine = null;
        for (Trip <T>ln : this.transportAreas) {
            double speed = ln.getSpeed();
            if (ln.getSpeed() > max) {
                max = speed;
                maxLine = ln;
            }
        }
        return maxLine;
    }

    public Set<T> sortingByNearEdges() {
        List<T> edges = new ArrayList<T>();
        edges.addAll(this.getEdges());
        Collections.sort(edges, (ed1, ed2) -> (this.getAllNearEdges(ed1).size() - (getAllNearEdges(ed2).size())) * -1);
        return new LinkedHashSet<>(edges);
    }

    private Set<T> getNearEdges(T sourceEdge) {
        Set<T> nearEdges = new HashSet<>();
        for (Trip<T> line : this.transportAreas) {
            T firtEdge = line.getFirstEndPoint();
            T secondEdge = line.getSecondEndPoint();
            if (firtEdge.equals(sourceEdge)) {
                nearEdges.add(secondEdge);
            } else if (secondEdge.equals(sourceEdge)) {
                nearEdges.add(firtEdge);
            }
        }
        return nearEdges;
    }

    Set<T> getAllNearEdges(T sourceEdge) {
        Set<T> fullNearEdges = new HashSet<>();
        Set<T> nearEdges = getNearEdges(sourceEdge);
        fullNearEdges.addAll(nearEdges);

        for (T nearEdge : nearEdges) {
            fullNearEdges.addAll(getNearEdges(nearEdge));
        }
        fullNearEdges.remove(sourceEdge);
        return fullNearEdges;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Set<Trip> getTransportAreas() {
        return transportAreas;
    }

    public void setTransportAreas(Set<Trip> transportAreas) {
        this.transportAreas = transportAreas;
    }

    public void setTransportAreas(HashSet<Trip> transportAreas) {
        this.transportAreas = transportAreas;
    }

}

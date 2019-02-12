package com.gmail.vyacheslavxxxxx;

import java.util.Comparator;

public class CompareTriangleByArea implements Comparator<Triangle> {

    @Override
    public int compare(Triangle t1, Triangle t2) {
	return Double.compare(t1.area(), t2.area()) * -1;
    }

}
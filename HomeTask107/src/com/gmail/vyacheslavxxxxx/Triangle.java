package com.gmail.vyacheslavxxxxx;

public class Triangle {
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle() {
	super();
    }

    public Triangle(double aSide, double bSide, double cSide) {
	super();
	this.aSide = aSide;
	this.bSide = bSide;
	this.cSide = cSide;
    }

    public double area() {
	double p = (this.aSide + this.bSide + this.cSide) / 2;
	return Math.sqrt(p * (p - this.aSide) * (p - this.bSide) * (p - this.cSide));
    }

    @Override
    public String toString() {
	return "area=" + area() + "]";
    } 
}
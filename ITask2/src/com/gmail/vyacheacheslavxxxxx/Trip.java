package com.gmail.vyacheacheslavxxxxx;

public class Trip<T> {

    private double distance;
    private double time;
    private T startPoint;
    private T endPoint;

    public static class TransportAreaException extends Exception {
        private static final long serialVersionUID = 1L;

        public TransportAreaException(String message) {
            super(message);

        }
    }

    public T getFirstEndPoint() {
        return startPoint;
    }

    public Trip(T firstEndPoint, T secondEndPoint) throws TransportAreaException {
        super();
        setStartPoint(firstEndPoint);
        setEndPoint(secondEndPoint);
    }

    public Trip(double distance, double time, T firstEndPoint, T secondEndPoint) throws TransportAreaException {
        super();
        this.distance = distance;
        this.time = time;
        setStartPoint(firstEndPoint);
        setEndPoint(secondEndPoint);
    }

    public void setStartPoint(T firstEndPoint) throws TransportAreaException {
        if (firstEndPoint.equals(this.endPoint)) {
            throw new TransportAreaException("Your endpoints is equals!!");
        }
        this.startPoint = firstEndPoint;
    }

    public T getSecondEndPoint() {
        return endPoint;
    }

    public void setEndPoint(T secondEndPoint) throws TransportAreaException {
        if (secondEndPoint.equals(this.startPoint)) {
            throw new TransportAreaException("Your endpoints is equals!!");
        }
        this.endPoint = secondEndPoint;
    }

    public Trip() {
        super();
    }

    public double getSpeed() {

        return distance / this.time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Line [distance=" + distance + ", time=" + time + ", firstEndPoint=" + startPoint
                + ", secondEndPoint=" + endPoint + "speed=" + this.getSpeed() + "]";
    }

}

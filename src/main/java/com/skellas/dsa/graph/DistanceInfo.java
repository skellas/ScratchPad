package com.skellas.dsa.graph;

public class DistanceInfo {
    private static final int DEFAULT_DISTANCE = -1;
    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        distance = DEFAULT_DISTANCE;
    }

    public DistanceInfo(int distance) {
        this.distance = distance;
    }

    public DistanceInfo(int distance, int lastVertex) {
        this.distance = distance;
        this.lastVertex = lastVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}

package com.skellas.dsa.graph;

public class WeightedDistanceInfo {

    private int distance;
    private int lastVertex;

    public WeightedDistanceInfo() {
        distance = Integer.MAX_VALUE;
    }

    public WeightedDistanceInfo(int distance, int lastVertex) {
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

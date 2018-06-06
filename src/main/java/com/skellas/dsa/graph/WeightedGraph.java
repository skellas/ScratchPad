package com.skellas.dsa.graph;

public interface WeightedGraph extends Graph {

    void addEdge(int v1, int v2, int weight);

    Integer getWeightedEdge(int v1, int v2);
}

package com.skellas.dsa.graph;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    List<Integer>getAdjacentVertices(int v);

    int getNumVertices();

    int getIndegree(int v);
}

package com.skellas.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0
                || v2 >= numVertices || v2 <0) {
            throw new IllegalArgumentException("Vertices not valid");
        }
        adjacencyMatrix[v1][v2] = 1;
        if (graphType.equals(GraphType.UNDIRECTED))
            adjacencyMatrix[v2][v1] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0)
            throw new IllegalArgumentException("Verex number is not valid");

        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i =0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1)
                adjacentVertices.add(i);
        }
        Collections.sort(adjacentVertices);

        return adjacentVertices;
    }
}

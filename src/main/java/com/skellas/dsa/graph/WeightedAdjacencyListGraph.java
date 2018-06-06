package com.skellas.dsa.graph;

import java.util.ArrayList;

public class WeightedAdjacencyListGraph extends AdjacencyListGraph implements WeightedGraph {
    private static final int DEFAULT_WEIGHT = 1;

    public WeightedAdjacencyListGraph(int numVertices, GraphType graphType) {
        this.vertices = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new WeightedGraphNode(i, DEFAULT_WEIGHT));
        }
        this.numVertices = vertices.size();
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, DEFAULT_WEIGHT);
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if (v1 >= numVertices || v1 < 0
                || v2 >= numVertices || v2 <0) {
            throw new IllegalArgumentException("Vertices not valid");
        }
        vertices.get(v1).addEdge(new WeightedGraphNode(v2, weight));
        if (graphType.equals(GraphType.UNDIRECTED))
            vertices.get(v2).addEdge(new WeightedGraphNode(v1, weight));

    }

    @Override
    public Integer getWeightedEdge(int v1, int v2) {
        return ((WeightedGraphNode)vertices.get(v1)).getWeightedEdge(v2);
    }
}

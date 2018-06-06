package com.skellas.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    private List<GraphNode> vertices;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyListGraph(int numVertices, GraphType graphType) {
        this.vertices = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new GraphNode(i));
        }
        this.numVertices = vertices.size();
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0
                || v2 >= numVertices || v2 <0) {
            throw new IllegalArgumentException("Vertices not valid");
        }
        vertices.get(v1).addEdge(v2);
        if (graphType.equals(GraphType.UNDIRECTED))
            vertices.get(v2).addEdge(v1);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0)
            throw new IllegalArgumentException("Verex number is not valid");
        return vertices.get(v).getAdjacentVertices();
    }
}

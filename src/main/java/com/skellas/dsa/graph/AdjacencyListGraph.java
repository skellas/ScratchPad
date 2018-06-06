package com.skellas.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    protected List<Node> vertices;
    protected GraphType graphType;
    protected int numVertices;

    public AdjacencyListGraph() {
    }

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
        vertices.get(v1).addEdge(new GraphNode(v2));
        if (graphType.equals(GraphType.UNDIRECTED))
            vertices.get(v2).addEdge(new GraphNode(v1));
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0)
            throw new IllegalArgumentException("Verex number is not valid");
        return vertices.get(v).getAdjacentVertices();
    }

    @Override
    public int getIndegree(int v) {
        if (v >= numVertices || v < 0)
            throw new IllegalArgumentException("Verex number is not valid");

        int indegree = 0;
        for (int i =0; i < numVertices; i++) {
            if (getAdjacentVertices(i).contains(v))
                indegree++;
        }
        return indegree;
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }
}

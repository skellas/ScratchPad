package com.skellas.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode {
    private int vertexId;
    private GraphNode next;

    public GraphNode(final int vertexId) {
        this.vertexId = vertexId;
    }

    public int getVertexId() {
        return vertexId;
    }

    public GraphNode getNext() {
        return next;
    }

    public void addEdge(int vertexId) {
        GraphNode transientNode = this;
        while (null != transientNode.getNext()) {
            transientNode = transientNode.getNext();
        }
        transientNode.next = new GraphNode(vertexId);
    }
    public List<Integer> getAdjacentVertices() {
        GraphNode transientNode = this;
        List<Integer> adjacentVertices = new ArrayList<>();
        while(null != transientNode.getNext()) {
            transientNode = transientNode.getNext();
            adjacentVertices.add(transientNode.getVertexId());
        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

}

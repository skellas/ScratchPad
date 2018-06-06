package com.skellas.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode implements Node {
    private int vertexId;
    protected Node next;

    public GraphNode(final int vertexId) {
        this.vertexId = vertexId;
    }

    public int getVertexId() {
        return vertexId;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node node) {
        this.next = node;
    }

    @Override
    public void addEdge(Node node) {
        Node transientNode = this;
        while (null != transientNode.getNext()) {
            transientNode = transientNode.getNext();
        }
        transientNode.setNext(node);

    }

    public List<Integer> getAdjacentVertices() {
        Node transientNode = this;
        List<Integer> adjacentVertices = new ArrayList<>();
        while(null != transientNode.getNext()) {
            transientNode = transientNode.getNext();
            adjacentVertices.add(transientNode.getVertexId());
        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

}

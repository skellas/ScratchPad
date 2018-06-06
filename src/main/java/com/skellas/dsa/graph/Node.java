package com.skellas.dsa.graph;

import java.util.List;

public interface Node {
    int getVertexId();
    Node getNext();
    void setNext(Node node);
    void addEdge(Node node);
    List<Integer> getAdjacentVertices();
}

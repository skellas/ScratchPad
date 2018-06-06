package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixGraphTest {
    private Integer n = 8;

    private Graph createGraph() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(n, Graph.GraphType.DIRECTED);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

        return graph;
    }

    @Test
    public void test_depth_first_traversal() {
        int[] visited = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            GraphTraversal.depthFirstTraversal(createGraph(), visited, i);
        }
    }

    @Test
    public void test_breadth_first_traversal() {
        for (int i = 0; i < n; i++) {
            GraphTraversal.breadthFirstTraversal(createGraph(), 1);
        }
    }
}
package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

import static com.skellas.dsa.graph.GraphGeneratorUtil.createAdjacencyMatrixGraph;
import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixGraphTest {
    private Integer n = 8;

    @Test
    public void test_depth_first_traversal() {
        int[] visited = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            GraphTraversal.depthFirstTraversal(createAdjacencyMatrixGraph(), visited, i);
        }
    }

    @Test
    public void test_breadth_first_traversal() {
            GraphTraversal.breadthFirstTraversal(createAdjacencyMatrixGraph(), 1);
    }

    @Test
    public void test_sort() {
        System.out.println(GraphTraversal.sort(createAdjacencyMatrixGraph()).toString());
    }

    @Test
    public void test_shortest_path() {
        GraphTraversal.shortestPath(createAdjacencyMatrixGraph(), 1, 4);
    }
}
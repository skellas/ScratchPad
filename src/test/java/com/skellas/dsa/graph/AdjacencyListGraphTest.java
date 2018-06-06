package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

import static com.skellas.dsa.graph.GraphGeneratorUtil.createAdjacencyListGraph;

public class AdjacencyListGraphTest {

    @Test
    public void test_depth_first_traversal() {
        GraphTraversal.depthFirstTraversal(createAdjacencyListGraph(), new int[] {0, 0, 0, 0, 0, 0, 0, 0}, 1);
    }

    @Test
    public void test_breadth_first_traversal() {
        GraphTraversal.breadthFirstTraversal(createAdjacencyListGraph(), 1);
    }

    @Test
    public void test_sort() {
       System.out.println(GraphTraversal.sort(createAdjacencyListGraph()).toString());
    }

    @Test
    public void test_shortest_path() {
        GraphTraversal.shortestPath(createAdjacencyListGraph(), 1, 4);
    }
}

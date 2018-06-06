package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

import static com.skellas.dsa.graph.GraphGeneratorUtil.createWeightedAdjacencyListGraph;

class WeightedAdjacencyListGraphTest {

    @Test
    public void test_depth_first_traversal() {
        WeightedGraphTraversal.depthFirstTraversal(createWeightedAdjacencyListGraph(), new int[] {0, 0, 0, 0, 0, 0, 0, 0}, 1);
    }

    @Test
    public void test_breadth_first_traversal() {
        WeightedGraphTraversal.breadthFirstTraversal(createWeightedAdjacencyListGraph(), 1);
    }

    @Test
    public void test_sort() {
        System.out.println(WeightedGraphTraversal.sort(createWeightedAdjacencyListGraph()).toString());
    }

    @Test
    public void test_shortest_path() {
        WeightedGraphTraversal.shortestPath(createWeightedAdjacencyListGraph(), 1, 4);
    }
}
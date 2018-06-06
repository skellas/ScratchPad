package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

public class AdjacencyListGraphTest {
    private Graph createGraph() {
        AdjacencyListGraph graph = new AdjacencyListGraph(8, Graph.GraphType.DIRECTED);

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
        GraphTraversal.depthFirstTraversal(createGraph(), new int[] {0, 0, 0, 0, 0, 0, 0, 0}, 1);
    }

    @Test
    public void test_breadth_first_traversal() {
        GraphTraversal.breadthFirstTraversal(createGraph(), 1);
    }
}

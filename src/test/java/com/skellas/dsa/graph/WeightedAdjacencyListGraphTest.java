package com.skellas.dsa.graph;

import org.junit.jupiter.api.Test;

import static com.skellas.dsa.graph.GraphGeneratorUtil.createWeightedAdjacencyListGraph;
import static com.skellas.dsa.graph.GraphGeneratorUtil.createdWeightedAdjacencyListGraphWithNegativeCycle;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class WeightedAdjacencyListGraphTest {

    @Test
    public void test_depth_first_traversal() {
        DijkstraTraversal.depthFirstTraversal(createWeightedAdjacencyListGraph(), new int[] {0, 0, 0, 0, 0, 0, 0, 0}, 1);
    }

    @Test
    public void test_breadth_first_traversal() {
        DijkstraTraversal.breadthFirstTraversal(createWeightedAdjacencyListGraph(), 1);
    }

    @Test
    public void test_sort() {
        System.out.println(DijkstraTraversal.sort(createWeightedAdjacencyListGraph()).toString());
    }

    @Test
    public void test_shortest_path_dijkstra() {
        DijkstraTraversal.shortestPath(createWeightedAdjacencyListGraph(), 1, 4);
    }

    @Test
    public void test_shortest_path_bellman_ford() {
        BellmanFordTraversal.shortestPath(createWeightedAdjacencyListGraph(), 1, 4);
    }

    @Test()
    public void test_shortest_path_bellman_ford_with_negative_cycle() {
        try {
            BellmanFordTraversal.shortestPath(createdWeightedAdjacencyListGraphWithNegativeCycle(), 1, 6);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }

    }

    @Test
    public void test_all_scenarios_from_course() {
        WeightedGraph graph1 = new WeightedAdjacencyListGraph(8, Graph.GraphType.DIRECTED);
        graph1.addEdge(2, 7, 4);
        graph1.addEdge(0, 3, 23);
        graph1.addEdge(0, 4, 23);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(2, 1, 3);
        graph1.addEdge(1, 3, 2);
        graph1.addEdge(3, 5, 1);
        graph1.addEdge(3, 6, 3);
        graph1.addEdge(4, 7, 2);
        graph1.addEdge(7, 5, 4);

        BellmanFordTraversal.shortestPath(graph1, 0, 5);


        WeightedGraph graph2 = new WeightedAdjacencyListGraph(5, Graph.GraphType.DIRECTED);
        graph2.addEdge(0, 1, 2);
        graph2.addEdge(0, 2, 1);
        graph2.addEdge(1, 3, 3);
        graph2.addEdge(1, 4, -2);
        graph2.addEdge(2, 4, 2);
        graph2.addEdge(4, 3, 1);
        graph2.addEdge(2, 1, -5);

        BellmanFordTraversal.shortestPath(graph2, 0, 3);

        WeightedGraph graph3 = new WeightedAdjacencyListGraph(5, Graph.GraphType.DIRECTED);
        graph3.addEdge(0, 1, 2);
        graph3.addEdge(0, 2, 3);
        graph3.addEdge(3, 1, 2);
        graph3.addEdge(1, 4, -5);
        graph3.addEdge(2, 4, 6);
        graph3.addEdge(4, 3, -4);

        try{
            BellmanFordTraversal.shortestPath(graph3, 0, 3);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
        WeightedGraph graph4 = new WeightedAdjacencyListGraph(6, Graph.GraphType.DIRECTED);
        graph4.addEdge(0, 1, 2);
        graph4.addEdge(1, 2, 3);
        graph4.addEdge(2, 3, 2);
        graph4.addEdge(3, 4, -5);
        graph4.addEdge(3, 5, 1);
        graph4.addEdge(4, 5, -3);
        graph4.addEdge(5, 4, -3);

        try {
            BellmanFordTraversal.shortestPath(graph4, 0, 5);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }
}
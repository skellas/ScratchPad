package com.skellas.dsa.graph;

public class GraphGeneratorUtil {

    private static final int DEFAULT_NUM_VERTICES = 8;
    private static final Graph.GraphType DEFAULT_GRAPH_TYPE = Graph.GraphType.DIRECTED;


    protected static WeightedGraph createWeightedAdjacencyListGraph() {
        return createWeightedAdjacencyListGraph(DEFAULT_NUM_VERTICES, DEFAULT_GRAPH_TYPE);
    }
    protected static WeightedGraph createWeightedAdjacencyListGraph(final int numVertices, final Graph.GraphType graphType) {
        WeightedAdjacencyListGraph graph = new WeightedAdjacencyListGraph(numVertices, graphType);

        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 7, 1);
        graph.addEdge(2, 4, 10);
        graph.addEdge(2, 3, 7); // change 7 to 2 to see shortest path swap
        graph.addEdge(1, 5, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(6, 3, 1);
        graph.addEdge(3, 4, 2);

        return graph;
    }

    protected static Graph createAdjacencyListGraph() {
        return createAdjacencyListGraph(DEFAULT_NUM_VERTICES, DEFAULT_GRAPH_TYPE);
    }
    protected static Graph createAdjacencyListGraph(final int numVertices, final Graph.GraphType graphType) {
        AdjacencyListGraph graph = new AdjacencyListGraph(numVertices, graphType);

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


    protected static Graph createAdjacencyMatrixGraph() {
        return createAdjacencyMatrixGraph(DEFAULT_NUM_VERTICES, DEFAULT_GRAPH_TYPE);
    }
    protected static Graph createAdjacencyMatrixGraph(final int numVertices, final Graph.GraphType graphType) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(numVertices, graphType);

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
}

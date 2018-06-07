package com.skellas.dsa.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BellmanFordTraversal extends GraphTraversal {

    public static void shortestPath(WeightedGraph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1)
            System.out.println("There is no path from node " + source + " to node " + destination);
        else {
            System.out.println("Smallest path is :");
            System.out.println(source);
            while (!stack.isEmpty())
                System.out.println(" -> " + stack.pop());
            System.out.println(" Shortest Path - Bellman Ford DONE!");
        }
    }

    private static Map<Integer, DistanceInfo> buildDistanceTable(WeightedGraph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo(10000));
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        for (int iter = 0; iter < graph.getNumVertices() -1; iter++) {
            for (int v = 0; v < graph.getNumVertices(); v++) {
                queue.add(v);
            }

            Set<String> visitedEdges = new HashSet<>();
            while (!queue.isEmpty()) {
                Integer currentVertex = queue.poll();

                for (Integer neighbor : graph.getAdjacentVertices(currentVertex)) {
                    String edge = String.valueOf(currentVertex) + String.valueOf(neighbor);
                    if (visitedEdges.contains(edge))
                        continue;
                    visitedEdges.add(edge);

                    int distance = distanceTable.get(currentVertex).getDistance()
                            + graph.getWeightedEdge(currentVertex, neighbor);

                    if (distanceTable.get(neighbor).getDistance() > distance) {
                        distanceTable.get(neighbor).setDistance(distance);
                        distanceTable.get(neighbor).setLastVertex(currentVertex);
                    }

                }
            }
            printDistanceTable(distanceTable);
        }

        for (int v2 = 0; v2 < graph.getNumVertices(); v2++) {
            queue.add(v2);
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : graph.getAdjacentVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbor);
                if (distanceTable.get(neighbor).getDistance() > distance) {
                    throw new IllegalArgumentException("The graph has a negative cycle");
                }
            }
        }


        return distanceTable;
    }

    private static void printDistanceTable(Map<Integer, DistanceInfo> distanceTable) {
        StringBuilder sb = new StringBuilder();
        sb.append("DistanceTable[");
        sb.append('\n');
        for (Map.Entry<Integer, DistanceInfo> entry : distanceTable.entrySet()) {
            sb.append("Entry: " + entry.getKey());
            sb.append("[distance: " + entry.getValue().getDistance());
            sb.append(", lastVertex: " + entry.getValue().getLastVertex());
            sb.append("]");
            sb.append('\n');
        }
        sb.append("]");
        sb.append('\n');
        System.out.print(sb.toString());
    }
}

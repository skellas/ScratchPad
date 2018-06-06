package com.skellas.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphTraversal {
    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1)
            return;

        visited[currentVertex] = 1;
        graph.getAdjacentVertices(currentVertex).forEach(v -> depthFirstTraversal(graph, visited, v));

        System.out.println(currentVertex + "->");
    }

    public static void breadthFirstTraversal(Graph graph, int rootVertex) {

        // store all nodes in a queue
        Deque<Integer> queue = new ArrayDeque();
        Set<Integer> visited = new HashSet<>();
        // add() is the same as addLast()
        queue.add(rootVertex);
        while (!queue.isEmpty()) {
            // remember to remove and not just "get"
            // remove() is the same as removeFirst()
            Integer currentVertex = queue.remove();
            if (!visited.contains(currentVertex)) {
                System.out.println(currentVertex + "->");
                queue.addAll(
                        graph.getAdjacentVertices(currentVertex)
                                .stream()
                                .filter(v -> !visited.contains(v))
                                .collect(Collectors.toList())
                );

                visited.add(currentVertex);
            }
        }
    }

    public static List<Integer> sort(Graph graph) {
        Deque<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if (indegree == 0)
                queue.add(vertex);
        }
        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);

                if (updatedIndegree == 0)
                    queue.add(adjacentVertex);
            }
        }

        if (sortedList.size() != graph.getNumVertices())
            throw new RuntimeException("The Graph had a cycle");

        return sortedList;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Deque<Integer> stack = new ArrayDeque();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1)
            System.out.println("There is no path from node " + source + " to node " + destination);
        else {
            System.out.println("Smallest path is " + source);
            while (!stack.isEmpty())
                System.out.println(" -> " + stack.pop());
            System.out.println(" Shortest Path - Unweighted DONE!");
        }
    }

    private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        for (int j=0; j< graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }
        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            for (int i : graph.getAdjacentVertices(currentVertex)) {
                int currentDistance = distanceTable.get(i).getDistance();
                if (currentDistance == -1) {
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currentVertex);

                    if (!graph.getAdjacentVertices(i).isEmpty())
                        queue.add(i);
                }
            }
        }
        return distanceTable;
    }


}

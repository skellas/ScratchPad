package com.skellas.dsa.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalTraversal extends GraphTraversal {

    public static void spanningTree(WeightedGraph graph) {
        // Priority Queue to store and retrieve the edges on the basis of their weight.
        PriorityQueue<EdgeInfo> queue = new PriorityQueue<>(new Comparator<EdgeInfo>() {
            @Override
            public int compare(EdgeInfo v1, EdgeInfo v2) {
                return v1.getWeight().compareTo(v2.getWeight());
            }
        });

        // Add all edges to the priority queue
        for (int i = 0; i < graph.getNumVertices(); i++) {
            for (int neighbor : graph.getAdjacentVertices(i)) {
                queue.add(new EdgeInfo(i, neighbor, graph.getWeightedEdge(i, neighbor)));
            }
        }

        Set<Integer> visitedVertices = new HashSet<>();
        Set<EdgeInfo> spanningTree = new HashSet<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int v = 0; v < graph.getNumVertices(); v++) {
            edgeMap.put(v, new HashSet<>());
        }

        while(!queue.isEmpty() && spanningTree.size() < graph.getNumVertices() -1) {
            EdgeInfo currentEdge = queue.poll();

            // Add the enw edge to the map and see if it causes a cycle.
            edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
            if (hasCycle(edgeMap)) {
                edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
                continue;
            }

            spanningTree.add(currentEdge);

            // add both vertices to the visited list
            visitedVertices.add(currentEdge.getVertex2());
            visitedVertices.add(currentEdge.getVertex1());
        }

        // check whether all vertices have been coered with the spanning tree
        if (visitedVertices.size() != graph.getNumVertices()) {
            System.out.println("Minimum Spanning Tree not possible.");
        } else {
            System.out.println("Minimum Spanning Tree using Kruskal's Algorithm");
            for (EdgeInfo e : spanningTree) {
                System.out.println(e);
            }
        }
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
        for (Integer sourceVertex : edgeMap.keySet()) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(sourceVertex);
            Set<Integer> visitedVertices = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();
                if (visitedVertices.contains(currentVertex)) {
                    return true;
                }

                visitedVertices.add(currentVertex);
                queue.addAll(edgeMap.get(currentVertex));
            }
        }
        return false;
    }
}

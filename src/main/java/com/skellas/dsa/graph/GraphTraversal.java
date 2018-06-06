package com.skellas.dsa.graph;

import com.skellas.dsa.tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
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
            }
            visited.add(currentVertex);
        }
    }
}

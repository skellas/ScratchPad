package com.skellas.dsa.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTTraversalTest {

    private BinaryTreeNode createSimpleTree() {
        BinaryTreeNode nodeACD = new BinaryTreeNode("D");
        BinaryTreeNode nodeACE = new BinaryTreeNode("E");
        BinaryTreeNode nodeAB = new BinaryTreeNode("B");
        BinaryTreeNode nodeAC = new BinaryTreeNode("C", nodeACD, nodeACE);
        return new BinaryTreeNode("A", nodeAB, nodeAC);
    }

    @Test
    public void test_simple_tree_breadth_first_traversal() {
        BTTraversal.breadthFirst(createSimpleTree());
    }

    @Test
    public void test_simple_tree_depth_first_traversal() {
        BTTraversal.depthFirst(createSimpleTree());
    }

}
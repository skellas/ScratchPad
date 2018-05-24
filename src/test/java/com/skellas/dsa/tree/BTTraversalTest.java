package com.skellas.dsa.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTTraversalTest {

    private BinaryTreeNode createSimpleTree() {
        BinaryTreeNode nodeAEH = new BinaryTreeNode("H");
        BinaryTreeNode nodeADG = new BinaryTreeNode("G");
        BinaryTreeNode nodeADF = new BinaryTreeNode("F");
        BinaryTreeNode nodeACE = new BinaryTreeNode("E", null, nodeAEH);
        BinaryTreeNode nodeACD = new BinaryTreeNode("D", nodeADF, nodeADG);
        BinaryTreeNode nodeAC = new BinaryTreeNode("C", nodeACD, nodeACE);
        BinaryTreeNode nodeAB = new BinaryTreeNode("B");
        return new BinaryTreeNode("A", nodeAB, nodeAC);
    }

    @Test
    public void test_breadth_first_traversal() {
        BTTraversal.breadthFirst(createSimpleTree());
    }

    @Test
    public void test_depth_first_traversal_with_loop() {
        BTTraversal.depthFirstWithLoop(createSimpleTree());
    }

    @Test
    public void test_pre_order_depth_first_traversal() {
        BTTraversal.depthFirstPreOrderWithRecursion(createSimpleTree());
    }

    @Test
    public void test_in_order_depth_first_traversal() {
        BTTraversal.depthFirstInOrderWithRecursion(createSimpleTree());
    }

    @Test
    public void test_post_order_depth_first_traversal() {
        BTTraversal.depthFirstPostOrderWithRecursion(createSimpleTree());
    }

}
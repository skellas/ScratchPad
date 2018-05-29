package com.skellas.dsa.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTTraversalTest {

    /*
        Tree Structure:
                  5
              3       8
           2   4    6    11
         1             9    12
     */
    private BinaryTreeNode createIntegerTree() {
        BinaryTreeNode node58119 = new BinaryTreeNode(9);
        BinaryTreeNode node581112 = new BinaryTreeNode(12);
        BinaryTreeNode node5811 = new BinaryTreeNode(11, node58119, node581112);
        BinaryTreeNode node586 = new BinaryTreeNode(6);
        BinaryTreeNode node5321 = new BinaryTreeNode(1);
        BinaryTreeNode node534 = new BinaryTreeNode(4);
        BinaryTreeNode node532 = new BinaryTreeNode(2, node5321, null);
        BinaryTreeNode node58 = new BinaryTreeNode(8, node586, node5811);
        BinaryTreeNode node53 = new BinaryTreeNode(3, node532, node534);
        return new BinaryTreeNode(5, node53, node58);
    }
    /*
         Tree Structure:
                  D
               B     G
             A  C   F   H
                   E
      */
    private BinaryTreeNode createStringTree() {
        BinaryTreeNode nodeDGFE = new BinaryTreeNode("E");
        BinaryTreeNode nodeDGH = new BinaryTreeNode("H");
        BinaryTreeNode nodeDGF = new BinaryTreeNode("F", nodeDGFE, null);
        BinaryTreeNode nodeDG = new BinaryTreeNode("G", nodeDGF, nodeDGH);
        BinaryTreeNode nodeDBC = new BinaryTreeNode("C");
        BinaryTreeNode nodeDBA = new BinaryTreeNode("A");
        BinaryTreeNode nodeDB = new BinaryTreeNode("B", nodeDBA, nodeDBC);
        return new BinaryTreeNode("D", nodeDB, nodeDG);
    }

    @Test
    public void test_breadth_first_traversal() {
        BTTraversal.breadthFirst(createStringTree());
    }

    @Test
    public void test_depth_first_traversal_with_loop() {
        BTTraversal.depthFirstWithLoop(createStringTree());
    }

    @Test
    public void test_pre_order_depth_first_traversal() {
        BTTraversal.depthFirstPreOrderWithRecursion(createStringTree());
    }

    @Test
    public void test_in_order_depth_first_traversal() {
        BTTraversal.depthFirstInOrderWithRecursion(createStringTree());
    }

    @Test
    public void test_post_order_depth_first_traversal() {
        BTTraversal.depthFirstPostOrderWithRecursion(createStringTree());
    }


    @Test
    public void test_insertion_of_i() {
        BinaryTreeNode<String> rootNode = createStringTree();
        // no node at this location on root
        assertNull(rootNode.getRight().getRight().getRight());

        BinaryTreeNode<String> returnedNode = BTTraversal.insert(rootNode, new BinaryTreeNode<>("i"));
        assertEquals(rootNode, returnedNode);
        // new node located here on returned node though
        assertEquals("i", returnedNode.getRight().getRight().getRight().getData());
    }

    @Test
    public void test_insertion_of_13() {
        BinaryTreeNode<Integer> rootNode = createIntegerTree();
        // no node at this location on root
        assertNull(rootNode.getRight().getRight().getRight().getRight());

        BinaryTreeNode<Integer> returnedNode = BTTraversal.insert(rootNode, new BinaryTreeNode<>(13));
        assertEquals(rootNode, returnedNode);
        // new node located here on returned node though
        assertEquals(13, returnedNode.getRight().getRight().getRight().getRight().getData());
    }

    @Test
    public void test_lookup_of_existing_node_value_f() {
        BinaryTreeNode<String> rootNode = createStringTree();
        BinaryTreeNode<String> foundNode = BTTraversal.lookup(rootNode, "f");
        assertNotNull(foundNode);
        assertEquals(foundNode, rootNode.getRight().getLeft());
    }

    @Test
    public void test_lookup_of_non_existent_node_value_q() {
        BinaryTreeNode<String> rootNode = createStringTree();
        BinaryTreeNode<String> foundNode = BTTraversal.lookup(rootNode, "q");
        assertNull(foundNode);
    }

    @Test
    public void test_lookup_of_existing_node_value_9() {
        BinaryTreeNode<Integer> rootNode = createIntegerTree();
        BinaryTreeNode<Integer> foundNode = BTTraversal.lookup(rootNode, 9);
        assertNotNull(foundNode);
        assertEquals(foundNode, rootNode.getRight().getRight().getLeft());
    }

    @Test
    public void test_lookup_of_non_existent_node_value_7() {
        BinaryTreeNode<Integer> rootNode = createIntegerTree();
        BinaryTreeNode<Integer> foundNode = BTTraversal.lookup(rootNode, 7);
        assertNull(foundNode);
    }

}
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

        BinaryTreeNode<String> returnedNode = BTTraversal.insert(rootNode, new BinaryTreeNode<>("I"));
        assertEquals(rootNode, returnedNode);
        // new node located here on returned node though
        assertEquals("I", returnedNode.getRight().getRight().getRight().getData());
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
        BinaryTreeNode<String> foundNode = BTTraversal.lookup(rootNode, "F");
        assertNotNull(foundNode);
        assertEquals(foundNode, rootNode.getRight().getLeft());
    }

    @Test
    public void test_lookup_of_non_existent_node_value_q() {
        BinaryTreeNode<String> rootNode = createStringTree();
        BinaryTreeNode<String> foundNode = BTTraversal.lookup(rootNode, "Q");
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

    @Test
    public void find_minimum_value_in_string_tree_with_loop() {
        BinaryTreeNode<String> node = createStringTree();
        while (!BTHelperUtil.isNull(node.getLeft())) {
            node = node.getLeft();
        }
        // smallest value should be "A"
        assertEquals("A", node.getData());
    }

    @Test
    public void find_minimum_value_in_integer_tree_with_loop() {
        BinaryTreeNode<Integer> node = createIntegerTree();
        while (!BTHelperUtil.isNull(node.getLeft())) {
            node = node.getLeft();
        }
        // smallest value should be 1
        assertEquals((Integer)1, node.getData());
    }

    @Test
    public void find_minimum_value_in_string_tree_with_recursion() {
        BinaryTreeNode<String> node = createStringTree();
        String minimumValue = (String)BTTraversal.findMinimumValue(node);
        // smallest value should be "A"
        assertEquals("A", minimumValue);
    }

    @Test
    public void find_minimum_value_in_integer_tree_with_recursion() {
        BinaryTreeNode<Integer> node = createIntegerTree();
        Integer minimumValue = (Integer)BTTraversal.findMinimumValue(node);
        // smallest value should be 1
        assertEquals((Integer)1, minimumValue);
    }

    @Test
    public void find_maximum_value_in_string_tree_with_recursion() {
        BinaryTreeNode<String> node = createStringTree();
        String maximumValue = (String)BTTraversal.findMaximumValue(node);
        // smallest value should be "H"
        assertEquals("H", maximumValue);
    }

    @Test
    public void find_maximum_value_in_integer_tree_with_recursion() {
        BinaryTreeNode<Integer> node = createIntegerTree();
        Integer maximumValue = (Integer)BTTraversal.findMaximumValue(node);
        // smallest value should be 12
        assertEquals((Integer)12, maximumValue);
    }

    @Test
    public void find_maximum_depth_of_string_tree() {
        BinaryTreeNode<Integer> node = createIntegerTree();
        // has max depth of 3
        assertEquals((Integer)3, BTTraversal.findMaximumDepth(node));
        // add a new node to make the max depth 4
        BTTraversal.insert(node, new BinaryTreeNode(15));
        // has max depth of 4
        assertEquals((Integer)4, BTTraversal.findMaximumDepth(node));
    }

    @Test
    public void is_integer_tree_valid() {
        BinaryTreeNode<Integer> node = createIntegerTree();
        assertTrue(BTTraversal.isBinarySearchTree(node, 1, 12));
    }

    @Test
    public void is_string_tree_valid() {
        BinaryTreeNode<String> node = createStringTree();
        assertTrue(BTTraversal.isBinarySearchTree(node, "A", "H"));
    }

    @Test
    public void test_invalid_trees() {
        // fails test because "I" is larger than D, but is found on the left child subtree
        BinaryTreeNode<String> sNode = createStringTree();
        sNode.getLeft().getRight().setRight(new BinaryTreeNode("I"));
        assertFalse(BTTraversal.isBinarySearchTree(sNode, "A", "I"));

        // fails test because 10 is smaller than 11, but is found on the right child subtree
        BinaryTreeNode<Integer> iNode = createIntegerTree();
        iNode.getRight().getRight().getRight().setLeft(new BinaryTreeNode(10));
        assertFalse(BTTraversal.isBinarySearchTree(iNode, 1, 12));

    }
}
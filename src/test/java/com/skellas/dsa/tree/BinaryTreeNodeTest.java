package com.skellas.dsa.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @Test
    public void test_node_creation_with_minimal_constructor() {
        BinaryTreeNode<String> rootNode = new BinaryTreeNode<String>("a");
        assertNotNull(rootNode);
        assertEquals("a", rootNode.getData());
        assertNull(rootNode.getLeft());
        assertNull(rootNode.getRight());
        System.out.println(rootNode.toString());
    }

    @Test
    public void test_node_creation_with_full_constructor() {
        BinaryTreeNode<String> childLeft = new BinaryTreeNode<>("b");
        BinaryTreeNode<String> childRight = new BinaryTreeNode<>("c");
        BinaryTreeNode<String> rootNode = new BinaryTreeNode<String>("a", childLeft, childRight);
        assertNotNull(rootNode);
        assertEquals("a", rootNode.getData());
        assertNotNull(rootNode.getLeft());
        assertNotNull(rootNode.getRight());
        System.out.println(rootNode.toString());
    }


    @Test
    public void test_left_and_right_setters() {
        BinaryTreeNode<String> childLeft = new BinaryTreeNode<>("b");
        BinaryTreeNode<String> childRight = new BinaryTreeNode<>("c");
        BinaryTreeNode<String> rootNode = new BinaryTreeNode<String>("a");
        assertNotNull(rootNode);
        assertEquals("a", rootNode.getData());
        assertNull(rootNode.getLeft());
        assertNull(rootNode.getRight());

        rootNode.setLeft(childLeft);
        rootNode.setRight(childRight);
        assertNotNull(rootNode.getLeft());
        assertNotNull(rootNode.getRight());
        System.out.println(rootNode.toString());
    }
}
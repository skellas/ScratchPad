package com.skellas.dsa.tree;

public class BTHelperUtil {

    /**
     * SUPER PRETTY FORMATTING
     * @param node
     */
    protected static void print(BinaryTreeNode node) {
        System.out.println(node.toString());
    }

    /**
     * Welcome to the sledge hammer approach.
     * Don't do something like this in a real project...
     * @param node
     */
    protected static void testNodeIsNotNull(BinaryTreeNode node) {
        if (testForNull(node))
            throw new RuntimeException("Node Cannot Be Null");
    }

    protected static boolean testForNull(BinaryTreeNode node) {
        return (null == node);
    }
}

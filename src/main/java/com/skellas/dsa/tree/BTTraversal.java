package com.skellas.dsa.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTTraversal {

    /**
     * Iterate over each sibling before moving down into the
     * right/left sub trees. This is accomplished using a queue.
     * @param root
     */
    public static void breadthFirst(BinaryTreeNode root) {
        BTHelperUtil.testNodeIsNotNull(root);
        // store all nodes in a queue
        Deque<BinaryTreeNode> queue = new ArrayDeque();
        // add() is the same as addLast()
        queue.add(root);
        while (!queue.isEmpty()) {
            // remember to remove and not just "get"
            // remove() is the same as removeFirst()
            BinaryTreeNode node = queue.remove();
            BTHelperUtil.print(node);
            if (node.hasLeft())
                queue.add(node.getLeft());
            if (node.hasRight())
                queue.add(node.getRight());
        }
    }


    /**
     * Pre Ordered Depth First Traversal, using a simple loop.
     * This is accomplished via a stack.
     * @param root
     */
    public static void depthFirstWithLoop(BinaryTreeNode root) {
        BTHelperUtil.testNodeIsNotNull(root);

        Deque<BinaryTreeNode> stack = new ArrayDeque();
        // push() is the same as addFirst()
        stack.push(root);
        while (!stack.isEmpty()) {
            // remember to remove and not just "get"
            // pop() is the same as removeFirst()
            BinaryTreeNode node = stack.pop();
            BTHelperUtil.print(node);
            // this will end up adding right, then left
            // which means that we will traverse left first, always
            if (node.hasRight())
                stack.push(node.getRight());
            if (node.hasLeft())
                stack.push(node.getLeft());
        }
    }

    /**
     * Process node, then left, then right.
     * @param root
     */
    public static void depthFirstPreOrderWithRecursion(BinaryTreeNode root) {
        BTHelperUtil.testNodeIsNotNull(root);
        // start with the root before traversing
        BTHelperUtil.print(root);
        // then the left node
        if (root.hasLeft())
            depthFirstPreOrderWithRecursion(root.getLeft());
        // then the right node
        if (root.hasRight())
            depthFirstPreOrderWithRecursion(root.getRight());
    }

    /**
     * Process left, then node, then right
     * @param root
     */
    public static void depthFirstInOrderWithRecursion(BinaryTreeNode root) {
        BTHelperUtil.testNodeIsNotNull(root);
        // start with the left node
        if (root.hasLeft())
            depthFirstInOrderWithRecursion(root.getLeft());
        // then the root node
        BTHelperUtil.print(root);
        // then the right node
        if (root.hasRight())
            depthFirstInOrderWithRecursion(root.getRight());
    }

    /**
     * Process left, then right, then node
     * @param root
     */
    public static void depthFirstPostOrderWithRecursion(BinaryTreeNode root) {
        BTHelperUtil.testNodeIsNotNull(root);
        // start with the left node
        if (root.hasLeft())
            depthFirstPostOrderWithRecursion(root.getLeft());
        // then the right node
        if (root.hasRight())
            depthFirstPostOrderWithRecursion(root.getRight());
        // then the root node
        BTHelperUtil.print(root);
    }

    public static BinaryTreeNode insert(final BinaryTreeNode head, final BinaryTreeNode nodeToInsert) {
        if (BTHelperUtil.isNull(head))
            return nodeToInsert;
        if (nodeToInsert.getData().compareTo(head.getData()) <= 0) {
            head.setLeft(insert(head.getLeft(), nodeToInsert));
        } else {
            head.setRight(insert(head.getRight(), nodeToInsert));
        }
        return head;
    }

    /**
     * Specialized to Nodes that hold Integer values.
     * This allows us to do simple comparing between values.
     * @param head
     * @param nodeToInsert
     * @return the head node
     */
    public static BinaryTreeNode<Integer> insertInteger(final BinaryTreeNode<Integer> head, final BinaryTreeNode<Integer> nodeToInsert) {
        if (BTHelperUtil.isNull(head))
            return nodeToInsert;
        if (nodeToInsert.getData() <= head.getData()) {
            head.setLeft(insertInteger(head.getLeft(), nodeToInsert));
        } else {
            head.setRight(insertInteger(head.getRight(), nodeToInsert));
        }
        return head;
    }

    public static BinaryTreeNode lookup(final BinaryTreeNode head, final Object valueToFind) {
        if (BTHelperUtil.isNull(head))
            return null;
        if (head.getData().compareTo(valueToFind) == 0)
            return head;
        if (head.getData().compareTo(valueToFind) < 0) {
            return lookup(head.getRight(), valueToFind);
        } else {
            return lookup(head.getLeft(), valueToFind);
        }
    }
    /**
     * Specialized to Nodes that hold Integer values.
     * @param head
     * @param valueToFind
     * @return the Node that contains the value
     */
    public static BinaryTreeNode<Integer> lookupInteger(final BinaryTreeNode<Integer> head, final Integer valueToFind) {
        if (BTHelperUtil.isNull(head))
            return null;
        if (valueToFind == head.getData())
            return head;
        if (valueToFind <= head.getData()) {
            return lookupInteger(head.getLeft(), valueToFind);
        } else {
            return lookupInteger(head.getRight(), valueToFind);
        }
    }

    /**
     * Find the smallest obtainable value in the tree
     * by traversing down the left hand path.
     * @param head
     * @return
     */
    public static Object findMinimumValue(final BinaryTreeNode head) {
        if (BTHelperUtil.isNull(head.getLeft()))
            return head.getData();
        return findMinimumValue(head.getLeft());
    }


    /**
     * Find the largest obtainable value in the tree
     * by traversing down the right hand path.
     * @param head
     * @return
     */
    public static Object findMaximumValue(final BinaryTreeNode head) {
        if (BTHelperUtil.isNull(head.getRight()))
            return head.getData();
        return findMaximumValue(head.getRight());
    }

    public static boolean isBinarySearchTree(BinaryTreeNode head, Object min, Object max) {
        if (BTHelperUtil.isNull(head))
            return true;
        if (head.getData().compareTo(min) < 0 || head.getData().compareTo(max) > 0) {
            return false;
        }
        return isBinarySearchTree(head.getLeft(), min, head.getData())
                && isBinarySearchTree(head.getRight(), head.getData(), max);
    }
    /**
     * Find the furthest branch that can be traversed in this tree
     * @param head
     * @return
     */
    public static Integer findMaximumDepth(final BinaryTreeNode head) {
        return findNextDepth(head, 0);
    }
    private static Integer findNextDepth(final BinaryTreeNode head, final Integer currentDepth) {
        Integer deepestTraversalLeft = currentDepth;
        Integer deepestTraversalRight = currentDepth;
        if (!BTHelperUtil.isNull(head.getLeft()))
            deepestTraversalLeft = findNextDepth(head.getLeft(), currentDepth + 1);
        if (!BTHelperUtil.isNull(head.getRight()))
            deepestTraversalRight = findNextDepth(head.getRight(), currentDepth +1);
        return deepestTraversalLeft > deepestTraversalRight ? deepestTraversalLeft : deepestTraversalRight;
    }

}

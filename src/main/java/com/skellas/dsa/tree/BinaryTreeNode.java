package com.skellas.dsa.tree;

public class BinaryTreeNode<T extends Comparable> {
    private T data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public boolean hasLeft() {
        return null != getLeft();
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public boolean hasRight() {
        return null != getRight();
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append('\n');
        sb.append("  Node Data: " + getData().toString());
        sb.append('\n');
        sb.append("  Node Left: " + (hasLeft() ? getLeft().getData().toString() : "null"));
        sb.append('\n');
        sb.append("  Node Right: " + (hasRight() ? getRight().getData().toString() : "null"));
        sb.append('\n');
        sb.append('}');
        return sb.toString();
    }
}

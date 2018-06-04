package com.skellas.dsa.heap;

import com.skellas.dsa.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapUtil {

    public static boolean isValidMinHeap(BaseHeap heap, int index) {
        // If a leaf node
        if (index > (heap.getCount() - 2)/2)
            return true;

        // If an internal node and is greater than its children, and
        // same is recursively true for the children
        if (heap.getElementAtIndex(index).compareTo(heap.getElementAtIndex(heap.getLeftChildIndex(index))) < 0
                && heap.getElementAtIndex(index).compareTo(heap.getElementAtIndex(heap.getRightChildIndex(index))) < 0
                && isValidMinHeap(heap, heap.getLeftChildIndex(index)) && isValidMinHeap(heap, heap.getRightChildIndex(index)))
            return true;

        return false;
    }

    public static boolean isValidMaxHeap(BaseHeap heap, int index) {
        // If a leaf node
        if (index > (heap.getCount() - 2)/2)
            return true;

        // If an internal node and is greater than its children, and
        // same is recursively true for the children
        if (heap.getElementAtIndex(index).compareTo(heap.getElementAtIndex(heap.getLeftChildIndex(index))) > 0
                && heap.getElementAtIndex(index).compareTo(heap.getElementAtIndex(heap.getRightChildIndex(index))) > 0
                && isValidMaxHeap(heap, heap.getLeftChildIndex(index)) && isValidMaxHeap(heap, heap.getRightChildIndex(index)))
            return true;

        return false;
    }

}

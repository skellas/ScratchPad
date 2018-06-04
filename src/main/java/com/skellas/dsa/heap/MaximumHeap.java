package com.skellas.dsa.heap;

public class MaximumHeap<T extends Comparable> extends BaseHeap{
    public MaximumHeap(Class clazz) {
        super(clazz);
    }

    public MaximumHeap(Class clazz, int size) {
        super(clazz, size);
    }

    public MaximumHeap(T[] unsortedArray) {
        super(unsortedArray);
    }


    @Override
    public void siftDown(int index, int endIndex) {
        int leftIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);

        int largerIndex;
        if (leftIndex != -1 && rightIndex != -1) {
            largerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) > 0
                    ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            largerIndex = leftIndex;
        } else {
            largerIndex = rightIndex;
        }
        if (largerIndex == -1)
            return;
        if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(largerIndex, index);
            siftDown(largerIndex, endIndex);
        }
    }

    @Override
    public void siftUp(int index, int endIndex) {
        int parentIndex = getParentIndex(index, endIndex);
        if (parentIndex != -1 &&
                getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0)
            swap(index, parentIndex);
        siftUp(parentIndex, endIndex);
    }

}

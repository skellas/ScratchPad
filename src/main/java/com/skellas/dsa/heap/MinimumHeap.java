package com.skellas.dsa.heap;

public class MinimumHeap<T extends Comparable> extends BaseHeap{
    public MinimumHeap(Class clazz) {
        super(clazz);
    }

    public MinimumHeap(Class clazz, int size) {
        super(clazz, size);
    }

    public MinimumHeap(T[] unsortedArray) {
        super(unsortedArray);
    }

    public void siftDown(int index, int endIndex) {
        int leftIndex = getLeftChildIndex(index, endIndex);
        int rightIndex = getRightChildIndex(index, endIndex);

        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0
                    ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else {
            smallerIndex = rightIndex;
        }
        if (smallerIndex == -1)
            return;
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex, endIndex);
        }
    }

    @Override
    public void siftUp(int index, int endIndex) {
        int parentIndex = getParentIndex(index, endIndex);
        if (parentIndex != -1 &&
                getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0)
            swap(index, parentIndex);
        siftUp(parentIndex, endIndex);
    }


}

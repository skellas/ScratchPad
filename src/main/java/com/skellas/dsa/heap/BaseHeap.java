package com.skellas.dsa.heap;

import java.lang.reflect.Array;

public abstract class BaseHeap<T extends Comparable> {
    private static int MAX_SIZE = 40;
    private T[] array;
    private int count = 0;

    public BaseHeap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }
    public BaseHeap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }
    public BaseHeap(T[] unsortedArray) {
        array = unsortedArray;
        count = array.length;
        heapify();
    }

    /**
     * Find the 'left child' in the array
     * @param index
     * @return index of the left child node
     */
    public int getLeftChildIndex(int index) {
        return getLeftChildIndex(index, array.length -1);
    }
    public int getLeftChildIndex(int index, int endIndex){
        int leftChildIndex = 2*index + 1;
        if (leftChildIndex >= count || leftChildIndex > endIndex)
            return -1;
        return leftChildIndex;
    }

    /**
     * Find the 'right child' in the array
     * @param index
     * @return index of the right child node
     */
    public int getRightChildIndex(int index) {
        return getRightChildIndex(index, array.length - 1);
    }
    public int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2*index + 2;
        if (rightChildIndex >= count || rightChildIndex > endIndex)
            return -1;
        return rightChildIndex;
    }

    /**
     * Find the 'parent' in the array
     * @param index
     * @return index of the parent node
     */
    public int getParentIndex(int index) {
        return getParentIndex(index, array.length - 1);
    }
    public int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > count || index > endIndex)
            return -1;
        return (index - 1) / 2;
    }

    public void siftDown(int index){
        siftDown(index, array.length - 1);
    }
    public abstract void siftDown(int index, int endIndex);
    public void siftUp(int index) {
        siftUp(index, array.length -1);
    }
    public abstract void siftUp(int index, int endIndex);

    protected void heapify() {
        int index = getParentIndex(array.length - 1);
        while (index >= 0) {
            siftDown(index);
            index--;
        }
    }
    protected void sort() {
        heapify();

        int endIndex = array.length - 1;
        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
        }
    }

    protected void swap(int i1, int i2) {
        T tempVal = array[i1];
        array[i1] = array[i2];
        array[i2] = tempVal;
    }

    public int getCount() {
        return count;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == array.length;
    }
    public T getElementAtIndex(int i) {
        return array[i];
    }
    public void insert(T val) {
        if (isFull())
            throw new RuntimeException("Heap Full");
        array[count] = val;
        siftUp(count);
        count++;
    }
    public T remove() {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");

        T head = getElementAtIndex(0);
        swap(0, count-1);
        count--;
        siftDown(0);

        return head;
    }
}

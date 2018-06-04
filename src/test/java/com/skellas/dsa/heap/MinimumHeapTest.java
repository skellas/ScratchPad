package com.skellas.dsa.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MinimumHeapTest {

    private Integer[] createIntegerArray() {
        return new Integer[]{1,2,4,3,5,8,6,9,23,41,7,22,18,34,16};
    }

    @Test
    public void test_sorting_of_min_heap() {
        MinimumHeap<Integer> heap = new MinimumHeap<Integer>(createIntegerArray());
        assertTrue(HeapUtil.isValidMinHeap(heap, 0));
    }

}
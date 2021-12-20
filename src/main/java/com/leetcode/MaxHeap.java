package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    public List<Integer> list;

    public MaxHeap(int capacity) {
        list = new ArrayList<>(capacity);
    }

    public void add(int num) {
        list.add(num);
        int cur = list.size() - 1;
        while ((cur - 1) / 2 != 0 && list.get((cur - 1)/2) < num) {
            swap(cur, (cur - 1)/2);
            cur = (cur - 1) / 2;
        }
    }

    public int getTop() {
        int res = list.get(0);
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);
        int cur = 0;
        while (2 * cur + 1 < list.size()) {
            if (cur * 2 + 2 < list.size()) {
                if (list.get(cur * 2 + 2) > list.get(cur * 2 + 1)) {
                    if (list.get(cur) > list.get(cur * 2 + 2)) {
                        break;
                    } else {
                        swap(cur, cur * 2 + 2);
                        cur = cur * 2 + 2;
                    }
                } else {
                    if (list.get(cur) > list.get(cur * 2 + 1)) {
                        break;
                    } else {
                        swap(cur, cur * 2 + 1);
                        cur = cur * 2 + 1;
                    }
                }
            } else {
                if (list.get(cur) > list.get(cur * 2 + 1)) {
                    break;
                } else {
                    swap(cur, cur * 2 + 1);
                    cur = cur * 2 + 1;
                }
            }
        }
        return res;
    }

    private void swap(int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);

        for (int i : heap.list) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println(heap.getTop());
//        for (int i : heap.list) {
//            System.out.println(i);
//        }
        System.out.println(heap.getTop());
        System.out.println(heap.getTop());
        System.out.println(heap.getTop());
        System.out.println(heap.getTop());
    }


}

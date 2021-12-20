package com.leetcode;

import java.util.HashMap;

public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] d = new int[arr.length][arr.length];
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (map.containsKey(arr[i] + arr[j])) {
                    d[j][map.get(arr[i] + arr[j])] = d[i][j] + 1;
                }
            }
        }

        int max = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                max = d[i][j] > max ? d[i][j] : max;
            }
        }
        return max + 1;
    }
}

package com.leetcode;

import java.util.*;

public class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> d = new HashMap<>();
        for (int j : arr) {
            int ans = j - difference;
            if (d.containsKey(ans)) {
                d.put(j, d.get(ans) + 1);
            } else {
                d.put(j, 1);
            }
        }
        return Collections.max(d.values());
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        longestSubsequence.longestSubsequence(new int[] {1,5,7,8,5,3,4,2,1}, -2);
    }
}

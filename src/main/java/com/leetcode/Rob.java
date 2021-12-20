package com.leetcode;

public class Rob {
    public int rob(int[] nums) {
        int[][] d = new int[nums.length][2];
        d[0][0] = 0;
        d[0][1] = nums[0];
        for (int i=1; i < nums.length; i++) {
            if (i > 1) {
                d[i][1] = Math.max(d[i-2][1], d[i-2][0]) + nums[i];
            } else {
                d[i][1] = nums[i];
            }
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
        }
        return Math.max(d[nums.length-1][0], d[nums.length-1][1]);
    }

}

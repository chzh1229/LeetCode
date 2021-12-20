package com.leetcode;

import java.util.Arrays;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int[][] d = new int[nums.length][nums.length];
        for (int k=0; k<nums.length; k++) {
            d[k][k] = nums[k];
        }
        for (int i = nums.length - 1; i>=0; i--) {
            for (int j = i+1; j<nums.length; j++) {
                d[i][j] = Math.max(nums[i] - d[i+1][j], nums[j] - d[i][j-1]);
            }
        }

        return d[0][nums.length] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,233,7};
        PredictTheWinner p = new PredictTheWinner();
        p.PredictTheWinner(nums);
    }
}

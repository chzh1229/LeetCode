package com.leetcode;

public class MaxProfit {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) {
            return 0;
        }
        int[][] d = new int[prices.length][2];
        d[0][0] = 0;
        d[0][1] = -prices[0];
        for (int i = 1; i< prices.length; i++) {
            d[i][0] = Math.max(d[i-1][0], d[i-1][1] + prices[i] - fee);
            d[i][1] = Math.max(d[i-1][1], d[i-1][0] - prices[i]);
        }

        return d[prices.length-1][0];
    }
}

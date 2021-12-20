package com.leetcode;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int[][] d = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[0].length; j++) {
                int value = Integer.parseInt(String.valueOf(matrix[i][j]));
                if (j == 0 || i == 0) {
                    d[i][j] = value;
                } else if (value > 0) {
                    d[i][j] = Math.min(Math.min(d[i-1][j-1]+1, d[i-1][j]+1), d[i][j-1]+1);
                } else {
                    d[i][j] = 0;
                }
                if (d[i][j] > max) max=d[i][j];
            }
        }
        return max * max;
    }
}

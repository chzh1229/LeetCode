package com.leetcode;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] d = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0; i<obstacleGrid.length; i++) {
            for (int j=0; j<obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    d[i][j] = 1;
                } else if (i == 0) {
                    d[i][j] = d[i][j-1];
                } else if (j == 0) {
                    d[i][j] = d[i-1][j];
                } else {
                    d[i][j] = d[i-1][j] + d[i][j-1];
                }
            }
        }
        return d[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

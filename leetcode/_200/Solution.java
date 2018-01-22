package _200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by didi on 22/01/2018.
 */
class Solution {

    static int countIslands;
    static boolean[][] used;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length ==0 || grid[0] == null) return 0;//YC: 二维数组的特殊输入分三种情况.

        countIslands = 0;
        used = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !used[i][j] && floodFill(grid, i, j)) {
                    countIslands++;
                }
            }
        }
        return countIslands;
    }

    //从grid[i][j]开始,查找并占领'1'.
    public boolean floodFill(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            System.out.println(i + "," + j);
            if (grid[i][j] == '1' && used[i][j] == false) {
                used[i][j] = true;
                //向上下左右继续查找并占领'1'.
                floodFill(grid, i - 1, j);
                floodFill(grid, i, j + 1);
                floodFill(grid, i + 1, j);
                floodFill(grid, i, j - 1);
                return true;
            }
        }
        return false;
    }

    //功能性测试
    @Test
    void test1() {
        char[][] r =
                       {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        assertEquals(1, numIslands(r));
    }

    @Test
    void test11() {
        char[][] r =
                       {{'0', '1', '1'},
                        {'1', '0', '0'},
                        {'1', '1', '0'},
                        {'0', '0', '0'}};
        assertEquals(2, numIslands(r));
    }

    //边界值测试
    @Test
    void test2() {
        char[][] r = {{'1'}};
        assertEquals(1, numIslands(r));
    }

    @Test
    void test22() {
        char[][] r = {{'0'}};
        assertEquals(0, numIslands(r));
    }

    //特殊输入测试
    @Test
    void test3() {
        char[][] r = {{}};//一个不空的二维数组, 第一个数组为空数组
        assertEquals(0, numIslands(r));
    }

    @Test
    void test33() {
        char[][] r =  {};//一个不空的二维数组, 没有任何元素.
        assertEquals(0, numIslands(r));
    }

    @Test
    void test333() {
        char[][] r =  null;//一个空的二维数组.
        assertEquals(0, numIslands(r));
    }
}

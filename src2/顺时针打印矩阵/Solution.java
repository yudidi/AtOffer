package 顺时针打印矩阵;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Created by didi on 28/01/2018.
 */
/*
# 题意
顺时针打印矩阵, 即: 先打印外圈,再打印内圈

# 分析
1. 每一圈的起点,都是x,y坐标相等的点.

# 思路
1. 遍历x=y的点, =>for
2. 内部四个for, 依次执行右,下,左,上的打印.
3. 重复1,2步.

# 复杂度
T(n): O(max(w.h)) * O(n2) = O(n2)
外层for: O(max(w,h))
内层for:(2w+2h) + (2(w-1)+2(h-) + (1+1) = O(n2)

# 代码
//TODO
向右打印, 行不变, 起始列是起点的列号.
向下打印,列不变, 起始行是起点行+1.  //单行不执行: 起始行一开始就越界
向左打印, 行不变, 起始列是向右打印的终点列号-1 //单列不执行: 起始列一开始就越界
向上打印, 列不变, 起始行是向下打印的终点行号-1 //单行不执行: 起始行一开始就是起点,不能再打印

单行: 向右
单列: 向右,向下

# 疑问
1. 二维数组是否规则,即每行的元素个数是否相等.

# 函数签名
1.  ArrayList<Integer> printMatrix(int [][] matrix)  //打印结果按照顺序放入数组中.

# bug
特殊输入

 */

public class Solution {
    //只能处理规则的二维数组
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int count = 0;
        int h = matrix.length, w = matrix[0].length;
        int rCol = 0, downRow = 0, lCol = 0, upRow = 0;
        int layers = (Math.min(w, h) - 1) / 2 + 1; //这个是层数 //YDD:圈数
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (col == row && count < layers) {//fix bug
                    System.out.println("开始打印第" + count + "圈");
                    System.out.println("向右");
                    for (rCol = col; rCol <= w - 1 - count; rCol++) {
                        res.add(matrix[row][rCol]);
                        System.out.println(matrix[row][rCol]);
                    }
                    System.out.println("向下");
                    for (downRow = row + 1; downRow <= h - 1 - count; downRow++) {
                        res.add(matrix[downRow][rCol - 1]);
                        System.out.println(matrix[downRow][rCol - 1]);
                    }

                    System.out.println("向左");
                    if (downRow == row + 1){
                        count++;
                        continue;
                    }
                    for (lCol = rCol - 1 - 1; lCol >= col; lCol--) {
                        res.add(matrix[downRow - 1][lCol]);
                        System.out.println(matrix[downRow - 1][lCol]);
                    }

                    System.out.println("向上");
                    if (lCol == rCol - 1 - 1) {
                        count++;
                        continue;
                    }
                    for (upRow = downRow - 1 - 1; upRow > row; upRow--) {
                        res.add(matrix[upRow][col]);
                        System.out.println(matrix[upRow][col]);
                    }
                    System.out.println("结束打印第" + count + "圈");
                    count++;
                }
            }
        }
        return res;
    }

    //功能测试
    @Test
    void test() {
        //每圈都打印2行2列
        int[][] arr = {
                {1, 2},
                {3, 4},
        };
        System.out.println(printMatrix(arr));
    }

    //fix bug // if (col == row && count < layers) {
    @Test
    void test1() {
        //内圈打印不足2行2列
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
        };
        System.out.println(printMatrix(arr));
    }

    @Test
    void test11() {
        //内圈打印不足2行2列
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(printMatrix(arr));
    }

    @Test
    void test111() {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(printMatrix(arr));
        System.out.println("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.");
    }

    @Test
    void test1111() {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(printMatrix(arr));
        System.out.println("[1,2,3,4,5,10,15,14,13,12,11,6,7,8,9]");
    }

    //对于二维数组的变量,两个变量的意义.
    void test2() {
        int[][] arr = {
                {1, 2, 3},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15}
        };
        for (int i = 0; i < arr.length; i++) {//行索引
            for (int j = 0; j < arr[i].length; j++) {//列索引
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
    }

    //边界测试
    @Test
    void test3() {
        //单行
        int[][] arr = {
                {1, 2, 3},
        };
        System.out.println(printMatrix(arr));
    }

    @Test
    void test31() {
        //单列
        int[][] arr = {
                {1},
                {2},
                {3},
        };
        System.out.println(printMatrix(arr));
    }
}

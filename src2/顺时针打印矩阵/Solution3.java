package 顺时针打印矩阵;

import java.util.ArrayList;

/**
 * Created by didi on 28/01/2018.
 */

//主体循环部分才5行。其实是有规律可循的。将每一层的四个边角搞清楚就可以打印出来了
public class Solution3 {
    public ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) return result;
        int n = array.length, m = array[0].length;
        if (m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数 //YDD:圈数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(array[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(array[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}
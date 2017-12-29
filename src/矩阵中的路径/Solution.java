package 矩阵中的路径;

/**
 * Created by didi on 27/12/2017.
 */
public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 參数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // 记录已经匹配的字符个数。
        int pathLength  = 0;
        // 以每个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength )) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *  功能: 剩余字符串的第一个字符是否可以放到当前的矩阵位置中.
     *    str[pathLength]  , matrix[row*每行的个数+col]
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param visited
     * @param row
     * @param col
     * @param pathLength
     * @return
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int pathLength ) {

        if (pathLength  == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 推断位置是否合法
        /**
         * YDD: 合法的格子
         *  1. 格子的行号和列号要合法.
         *  2. 格子的内容必须等于  要处理的字符. str[pathLength ]
         *
         */
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength ] //YDD: 当前需要放置的字符
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength ++;//YDD: 剩余需要放置的字符减少一个

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength )
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength )
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength )
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength );

            if (!hasPath) {
                pathLength --;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }

}
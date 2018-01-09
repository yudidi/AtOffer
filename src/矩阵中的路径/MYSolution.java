package 矩阵中的路径;

/**
 * Created by didi on 27/12/2017.
 */
public class MYSolution {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        //遍历全部的情况
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (判断是否存放字符串str(matrix,rows,cols,i,j,str,0)){
                    return  true;
                }
            }
        }
        return false;
    }

    private boolean 判断是否存放字符串str(char[] matrix, int rows, int cols, int row, int col, char[] str, int rest) {
        //0. 已经存放完成. 退出递归
        //1. 判断当前的格子是否可以放当前的字符
        //2. 判断上下左右的格子,是否可以放下一个字符. ==>四个子问题(搜索的起点更靠近终点,需放置的字符串在变短)
        return false;
    }
}
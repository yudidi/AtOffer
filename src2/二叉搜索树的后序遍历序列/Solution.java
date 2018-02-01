package 二叉搜索树的后序遍历序列;

import org.junit.jupiter.api.Test;

/**
 * Created by didi on 31/01/2018.
 */
/*
# 思路发现
[1,2,3,4,5]逐个插入构成的BST, 后序遍历[1,3,5,4,2]
# 规律
[左,右,根]
root: 当前的根节点
r1: 左子树的根节点
r2: 右子树的根节点
BST的后序遍历序列一定满足 r1<r<r2.
[左][右]也是后序遍历序列,也满足r1<r<r2.
# 思路
1. 把arr[l,r]以arr[r]分为大小两部分small[l,x],big[x+1,r-1]
2. 再判断small和big能够分为大小两部分.

# 代码
f() = {
1. 寻找满足条件r.
2. r1满足 && r2满足
}
# 递归函数参数确定
f(arr,int left,int right) //判断arr[left,right]是否是BST的后序遍历序列.

*/

public class Solution {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return core(sequence, 0, sequence.length - 1);
    }

    //arr[l,r]是否满足二叉搜索树的后序遍历序列的三种情况.
    private boolean core(int[] arr, int l, int r) {
//        System.out.printf("处理arr[%d,%d]\r\n", l, r);
        if (l == r) {
            return true;
        }
        if (isSkewTree(arr, l, r)) { //斜树
            return core(arr, l, r - 1);
        } else { //不斜
            return VerifySquenceOfNormalBST(arr, l, r);
        }
    }

    //是否是一颗斜树的序列.(左斜或右斜).
    private boolean isSkewTree(int[] arr, int l, int r) {
        int rootVal = arr[r];
        if (arr[r - 1] > rootVal) {//右斜
            for (int i = l; i < r - 1; i++) {
                if (arr[i] < rootVal) {
                    return false;
                }
            }
            return true;
        }
        for (int i = l; i < r - 1; i++) {
            if (arr[i] > rootVal) {
                return false;
            }
        }
        return true;
    }

    //判断序列是否为不斜的BST的后序遍历序列.
    private boolean VerifySquenceOfNormalBST(int[] arr, int l, int r) {
        if (arr[r - 1] < arr[r]) return false;
        int rootVal = arr[r];
        //反向遍历,找到左子树的根.
        int pos = r - 1;
        while (l <= pos) {
            if (arr[pos] < rootVal)
                break;
            pos--;
        }
        while (l <= --pos) {
            if (arr[pos] > arr[r])
                return false;
        }
        return true;
    }

    //功能性测试
    @Test
    void test() {
        int[] arr = {1};
        System.out.println(VerifySquenceOfBST(arr));
    }

    @Test
    void test1() {
        int[] arr = {1, 2};
        System.out.println(VerifySquenceOfBST(arr));
    }

    @Test
    void test11() {
        int[] arr = {1, 3, 2};
        System.out.println(VerifySquenceOfBST(arr));
    }

    @Test
    void test111() {
        int[] arr = {1, 3, 4, 2};
        System.out.println(VerifySquenceOfBST(arr));
    }

    @Test
    void test1111() {
        int[] arr = {1, 3, 5, 4, 2};
        System.out.println(VerifySquenceOfBST(arr));
    }

    //遗忘的case//斜树
    @Test
    void test_forget() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(VerifySquenceOfBST(arr));
    }

    //错误case
    @Test
    void test2() {
        int[] arr = {4, 2, 3, 1};
        System.out.println(VerifySquenceOfBST(arr));
    }

    @Test
    void test22() {
        int[] arr = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(arr));
    }
}

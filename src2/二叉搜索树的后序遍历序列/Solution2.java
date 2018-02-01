package 二叉搜索树的后序遍历序列;

import org.junit.jupiter.api.Test;

/**
 * Created by didi on 31/01/2018.
 */

public class Solution2 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0 || sequence == null) return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    //先按照不斜的情况编码, 然后发现编码依然使用于左斜和右斜的情况
    private boolean judge(int[] arr, int l, int r) {
        if (l >= r) {
            return true;
        }
        //定位左子树的最后一个节点
        int i = r - 1;
        while (i >= l && arr[i] > arr[r]) {//退出循环时,i就是左子树的根节点. //右斜数: i=l-1,左子树不存在  //不斜树: i就是左子树的根.
            i--;
        }
        //判断左子树序列是否都小于arr[r].
        int j = i;
        while (j >= l) {
            if (arr[j] > arr[r])
                return false;
            j--;
        }
        return judge(arr, l, i) && judge(arr, i + 1, r - 1);
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

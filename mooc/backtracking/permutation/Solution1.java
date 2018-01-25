package backtracking.permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by didi on 24/01/2018.
 */
/*
优化点:
1. 改进了判断一个数i是否使用过的方法.
    之前是: 每次遍历p,查看i是否在p中,即i是否被使用过.
    现在是: 借助一个外部数据结构, 给每个数是否使用做一个标记.

注意点: 在for循环的广度遍历中, 每次循环后, 需要把状态恢复为父问题的状态. (恢复(可用数的状态used 和 已用数的状态p), 因为p没有被修改,只需要恢复used);
 */
public class Solution1 {

    static boolean[] used;

    public List<String> permutation(int[] arr, int n) {

        used = new boolean[n];

        List<String> r = new ArrayList<>();
        core(arr, n, "", r);
        return r;
    }

    /*
     // p: 已有的排列
     // r:存放最终排列的结果
     从候选数容器,选择一个数,放入已有排列容器.
     */
    void core(int[] arr, int n, String p, List<String> r) {
        if (p.length() == n) {
            r.add(p);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                core(arr, n, p + arr[i], r);
                used[i] = false;
            }
        }
    }

    @Test
    void test() {
        int[] arr = {1, 2, 3};
        System.out.println(permutation(arr, arr.length));
    }
}

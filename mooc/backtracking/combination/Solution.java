package backtracking.combination;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by didi on 24/01/2018.
 */
public class Solution {

//    static int count = 0;

    //C(n,k)的结果,放入List<List<Integer>>.
    public List<List<Integer>> combination(int[] arr, int k) {
        List<List<Integer>> r = new ArrayList<>();

        if (arr == null || arr.length == 0 || k > arr.length || k <= 0)
            return r;
        core(arr, arr.length, 0, new ArrayList<>(), k, r);
        return r;
    }

    /*
    思路2: 使用(arr+start)两个参数. 使得一个数组可以存放逻辑上的两个容器: 1. 已选数容器 (arr[0..start-1])  2. 候选数容器(arr[start..n-1])
     */
    void core(int[] arr, int n, int start, List<Integer> p, int k, List<List<Integer>> r) {
//        System.out.println("======" + ++count + "=========");
//        System.out.println("已选择数容器:" + p);
//        System.out.println("结果容器:" + r);
        if (p.size() == k) {
            r.add(p);
            return;
        }
        for (int i = start; i < n; i++) {
            p.add(arr[i]);
            core(arr, n, i + 1, new ArrayList<>(p), k, r); //bug:容器p需要拷贝一份,否则会被子问题修改 //fix bug: p=> new ArrayList<>(p)
            p.remove(p.size() - 1);
        }
    }
}
/*
# 组合问题
core(arr, n, i + 1, new ArrayList<>(p), k, r); //使用i+1, 因为组合问题, 之前的分支选择过arr[i]之前的数,那么剩余的分支不能再选择arr[i]之前的数.
# 排列问题
core(arr, cur + 1, r);//[0..cur+1-1]已选择的数 ,[cur+1..n-1]候选的数. //使用cur+1而不是i+1, 因为这里是要列举cur位置的所有情况, cur可以是arr[cur,n-1]的任何一个数.,
*/

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
            core(arr, n, i + 1, new ArrayList<>(p), k, r); //bug:  core(arr, n, i + 1, p , k, r);
            p.remove(p.size() - 1);
        }
    }
}

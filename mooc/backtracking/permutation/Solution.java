package backtracking.permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by didi on 24/01/2018.
 */
public class Solution {

    public List<String> permutation(int[] arr, int n) {
        List<String> r = new ArrayList<>();
        core(arr, n, "", r);
        return r;
    }

    boolean isUsed(String p, int c) {
        for (char i : p.toCharArray()) {//bug:   for (int i : p.toCharArray())  //返回ascll码
            if (i - '0' == c) {  //bug: i是字符  ; c是数字   //bug: 举例: i='1' 不等于 c=1
                return true;
            }
        }
        return false;
    }

    /*
     // p: 已有的排列
     // r:存放最终排列的结果
     从候选数容器 (arr[0..n].select(not used)) ,选择一个数,放入已有排列容器p.
     */
    void core(int[] arr, int n, String p, List<String> r) {
        if (p.length() == n) {
            r.add(p);
            return;
        }
        for (int i : arr) {
            System.out.println("p:" + p + "  c:" + i + "  isUsed(p, i):" + isUsed(p, i));
            if (isUsed(p, i) == false) {
                core(arr, n, p + i, r);//候选数减一个,已选数加一.
            }
        }
    }


    @Test
    void test() {
        int[] arr = {1, 2, 3};
        System.out.println(permutation(arr, arr.length));
    }

}

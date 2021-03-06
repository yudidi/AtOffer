package backtracking.permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by didi on 24/01/2018.
 */

public class Solution2 {

    public List<String> permutation(int[] arr, int n) {
        List<String> r = new ArrayList<>();
        core(arr, 0, r);
        return r;
    }
    //TODO
    /*
         //不需要借助外部空间
    # 思路:
       处理cur位置的所有选择.
       arr[0..cur-1]已选择的数, arr[cur..n-1]未选择的数
     */
    public void core(int[] arr, int cur, List<String> r) {
        if (cur == arr.length - 1) {
//            r.add(Arrays.toString(arr));
            r.add(Arrays.stream(arr).boxed().map(i -> i.toString()) //必须将普通数组 boxed才能 在 map 里面 toString //lambda
                    .collect(Collectors.joining("")));
        }
        for (int i = cur; i < arr.length; i++) {//处理cur位置的所有选择
            swap(arr, i, cur);
            core(arr, cur + 1, r);//[0..cur+1-1]已选择的数 ,[cur+1..n-1]候选的数.
            swap(arr, i, cur);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    @Test
    void test() {
        int[] arr = {1, 2, 3};
        System.out.println(permutation(arr, arr.length));
    }
}


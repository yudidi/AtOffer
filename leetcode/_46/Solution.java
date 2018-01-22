package _46;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 46. Permutations
 * Created by didi on 20/01/2018.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        core(num,null,r);
        return r;
    }

    /*
    把num中可用的数,放到p容器中.
    p: 作为放东西的容器, 每放满一个就是一种放置方式.
     */
    public void core(int[] num,ArrayList<Integer> p, ArrayList<ArrayList<Integer>> r){
        if (p ==null){
            p = new ArrayList<>();
        }
        if (p.size() == num.length){
            r.add(p);
        }
        for (int i = 0; i < num.length ; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(p);//YC
            if (!p.contains(num[i])){
                //core(num,p.add(num[i]),r);
                tmp.add(num[i]);
                core(num,tmp,r);
            }
        }
    }

    @Test
    void test(){
        int[] num ={1,2,3};
        System.out.println(permute(num));
    }
}

package 机器人的运动范围;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by didi on 27/12/2017.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("1");
    }

    public int movingCount(int threshold, int rows, int cols) {

        return 0;
    }

    /**
     * 1. set:不能经过的格子集合
     * 2. 使用动规,二维数组对应着记录到达各个格子的路径数, 但是可达路径排除掉不能经过的格子.
     * 3. 最后统计二维数组中值>0的元素个数,就是该机器可以达到的格子个数
     * 注意: 边界上的格子,走法<4
     */

    /**
     * 问题简化: 统计机器人到达到各个格子的路径数.
     * 比如: 到(0行1列)的路径:
     * > 0.0->右->0.1
     * > 0.0->down->1.0->right->1.1->up->0.1
     */

    //记录行.列和>k的格子集合
    Set<String> getCannotCell(int k, int m, int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = sumOneByOne(i);
                int col = sumOneByOne(j);
                if (row+col == k) continue;
                set.add(row+":"+col);//k=18,(13,57),(15,37)
            }
        }
        return set;
    }

    @Test
    void  testSumOneByOne(){
        System.out.println("0:"+sumOneByOne(0));
        System.out.println("1:"+sumOneByOne(1));
        System.out.println("2:"+sumOneByOne(2));
        System.out.println("10:"+sumOneByOne(10));
        System.out.println("11:"+sumOneByOne(11));
        System.out.println("123:"+sumOneByOne(123));
    }

    int sumOneByOne(int i){
        int sum = 0; //123
        sum +=  i % 10;//+3
        do {
            i = i/10; //12 //1 //0
            sum += i%10;//+2 //+1 //+0
        }while (i!=0);//12 //1 //0
        return sum;
    }

}

package sortingAlgorithm.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * Created by didi on 18/01/2018.
 */
public class HeapSort {

    /**
     *  # 原地堆排序
     *  * 思路:
     *  1. heapfiy =  反向遍历非叶子节点 + shiftDown(当前非叶子节点,n-1).
     *  2. swap + shiftDown(0,当前堆尾).
     *
     * @param arr
     * @param n
     */
    void heapSort3(Integer[] arr,int n){

        if (n==0) return;

        //反向遍历非叶子节点,进行shiftdown操作 //i:当前的非叶子节点.
        for (int i = (n-1-1)/2; i >=0 ; i--) {
            shiftDown(arr,i,n-1);
        }

        //i:当前用于交换堆顶的位置. [n-1..1]
        for (int i = n-1; i > 0 ; i--) {
            swap(arr,0,i);
            shiftDown(arr,0,i-1);
        }
    }

    //对[head..tail]这部分子堆,进行shiftDown操作.
    private void shiftDown(Integer[] arr,int head, int tail) {
        //head:当前要考察的节点
        while ( 2*head+1 <=tail){
            int big = 2*head+1;
            if (big+1<=tail && arr[big+1]>arr[big]){
                big = big +1;
            }
            if (arr[head]>=arr[big]) return;
            swap(arr,head,big);
            head = big;
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        if (arr[i].equals(arr[j])) return;
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

    //功能性测试
    @Test
    void test1(){
        Integer[] arr = {3,2,1};
        heapSort3(arr,arr.length);
        assertArrayEquals(new Integer[]{1,2,3},arr);
    }

    @Test
    void test11(){
        Integer[] arr = {3,5,4,3,2,1};
        heapSort3(arr,arr.length);
        assertArrayEquals(new Integer[]{1,2,3,3,4,5},arr);
        System.out.println( Arrays.asList(arr));
    }


    //边界值测试
    @Test
    void test22(){
        Integer[] arr = {1};
        heapSort3(arr,arr.length);
        assertArrayEquals(new Integer[]{1},arr);
    }

    //特殊输入测试
    @Test
    void test2(){
        Integer[] arr = {};
        heapSort3(arr,arr.length);
        assertArrayEquals(new Integer[]{},arr);
    }
}

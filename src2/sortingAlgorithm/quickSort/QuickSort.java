package sortingAlgorithm.quickSort;

import org.junit.jupiter.api.Test;
import sortingAlgorithm.test.TestUtils;

/**
 * Created by didi on 15/01/2018.
 */
public class QuickSort {

    public void quickSort(int[] arr,int n){
        quickSortCore(arr,0,n-1);
    }
    
    public void quickSortCore(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        int divided = partition(arr,l,r);
        quickSortCore(arr,l,divided-1);
        quickSortCore(arr,divided+1,r);
    }

    /*
    //对arr[l..r]的元素进行partition操作,划分为3个部分.
    //返回p,使得arr[l..p-1]<arr[p],同时arr[p+1..r]>arr[p].
    变量:
    mark: 哨兵. 数组第一个元素.
    big: 表示较大部分的第一个元素.  注意,我们并不需要一个指向较小部分的指针,仍然可以在处理全部元素后,通过swap(l,big-1)把哨兵的放在正确位置. [小][哨兵][大]
    big-1: 较小部分的最后一个元素.

     */
    public int partition(int[] arr, int l, int r) {
        int p = -1;
        int mark = arr[l];
        int big = -1; //big:较大部分的第一个元素
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] > mark) {
                if (big == -1) {
                    big = i;
                }
            } else {
                if (big != -1) {
                    //swap(arr[i],arr[big]
                    swap(arr, i, big);
                    //大指针前进一格
                    big = big + 1;
                }
            }
        }
        if (big == -1) {
            swap(arr, l, r);
            p = r;
        } else {
            swap(arr, l, big - 1);
            p = big - 1;
        }
        return p;
    }

    /*
    bug: 交换数组中相同位置的两个数.
    执行过程: swap(arr,0,0)
    1. arr[0] = arr[0
     */
    public void swap(int[] arr, int i, int big) {
        if (i==big) return; //bug: 给arr[i]赋值就是给arr[big]赋值,他们指向同一个元素.
        arr[i] = arr[big] ^ arr[i];
        arr[big] = arr[big] ^ arr[i];
        arr[i] = arr[big] ^ arr[i];
    }

    public void swapByTmp(int[] arr,int i,int big){
        int t = arr[i];
        arr[i] = arr[big];
        arr[big] = t;
    }


    @Test
    public void testPartition() {
        int[] arr = {3, 2, 1};//=>{1,2,3}
        TestUtils.printArray(arr);
        System.out.println("partition point index: " + partition(arr, 0, arr.length - 1));
        TestUtils.printArray(arr);

        arr = new int[]{3, 5, 3, 2, 1};//=>{1,2,|3|,5}
        TestUtils.printArray(arr);
        System.out.println("partition point index: " + partition(arr, 0, arr.length - 1));
        TestUtils.printArray(arr);
    }

    @Test
    public void testSwap() {
        int[] arr = {3, 2, 1};//=>{1,2,3}
        TestUtils.printArray(arr);
        swap(arr, 0, 1);
        TestUtils.printArray(arr);
    }

    /*
    Bug: 交换两个相同位置的数,产生bug.
     */
    @Test
    public void testSwapBug1() {
        int[] arr = {1};//=>[1,1]
        TestUtils.printArray(arr);
        swap(arr, 0, 0);
        TestUtils.printArray(arr);
    }

    @Test
    public void testSwapBug11() {
        int[] arr = {2};//=>[1,1]
        TestUtils.printArray(arr);
        swap(arr, 0, 0);
        TestUtils.printArray(arr);
    }

    @Test
    public void testQuickSort(){
        //功能测试
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        quickSort(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{3,3,2,1,1};
        TestUtils.printArray(arr);
        quickSort(arr, arr.length);
        TestUtils.printArray(arr);

        //边界测试
        arr = new int[]{1,2};
        TestUtils.printArray(arr);
        quickSort(arr, arr.length);
        TestUtils.printArray(arr);

        //特殊输入测试
        arr = new int[]{};
        TestUtils.printArray(arr);
        quickSort(arr, arr.length);
        TestUtils.printArray(arr);
    }
}

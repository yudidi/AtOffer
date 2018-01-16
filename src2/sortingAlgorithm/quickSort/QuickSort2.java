package sortingAlgorithm.quickSort;

import org.junit.jupiter.api.Test;
import sortingAlgorithm.test.TestUtils;

/**
 * Created by didi on 16/01/2018.
 */
public class QuickSort2 {
    public void quickSort(int[] arr,int n){
        quickSortCore(arr,0,n-1);
    }

    private void quickSortCore(int[] arr, int l, int r) {
        if (l>=r) return;
        int p = partition(arr,l,r);
        quickSortCore(arr,l,p-1);
        quickSortCore(arr,p+1,r);
    }

    /*
    # 变量: 通过动画分析出有2个指针.
    j: 小区间的尾元素.
    i: 当前要处理的元素.
    # 循环不变量:
    1. 小元素区间. arr[l+1..j]<v
    2. 大元素区间. arr[j+1..i)>v
     */
    //对arr[l..r]进行partition操作
    //返回p,使得arr[l..p-1] < arr[p] ; arr[p+1..r] > arr[p];  此时arr[p]就在正确的位置.
    private int partition(int[] arr, int l, int r) {
        int v = arr[l];
        //循环不变量(循环前,循环中,循环后):arr[l+1..j]<v ; arr[j+1..i)>v;
        int j = l;//YC:
        for (int i = l+1; i <=r ; i++) {
            if (arr[i]>v){
                continue;//继续考察下一个元素
            }else {
                swapByTmp(arr,j+1,i);
                j++;
            }
        }
        swapByTmp(arr,l,j);
        return j;
    }

    private void swapByTmp(int[] arr,int i,int big){
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

        arr = new int[]{3,2,1,4,5};//=>{1,2,|3|,5}
        TestUtils.printArray(arr);
        System.out.println("partition point index: " + partition(arr, 0, arr.length - 1));
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

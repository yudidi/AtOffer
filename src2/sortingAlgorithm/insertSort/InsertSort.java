package sortingAlgorithm.insertSort;

import org.junit.jupiter.api.Test;
import sortingAlgorithm.test.TestUtils;

/**
 * Created by didi on 14/01/2018.
 */
public class InsertSort {

    public void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {//i: 表示待插入的元素
            for (int j = i; j > 0; j--) {//j: 用于从后往前的相邻交换(j-1,j),把arr[i]交换到合适的位置,所以j最大取到i,j最小取到1.
                if (arr[j - 1] > arr[j]) {
                    arr[j] = arr[j - 1] ^ arr[j];
                    arr[j - 1] = arr[j - 1] ^ arr[j];
                    arr[j] = arr[j - 1] ^ arr[j];
                } else {
                    break;
                }
            }
        }
    }

    /*
      相邻交换==>多次比较(挪动)+一次赋值; 内层循环的多次相邻交换插入元素,变为多次挪动元素+一次插入.

     */

    public void insertSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {//i:待插入的元素的索引
            int insert = arr[i];//保留待插入元素的副本.
            //YC: //j:考察insert是不是应该放在j位置,[i,i-1,..1],注意位置0不用考察,直接放置.
            int j = i;
            //ND: 循环考察"除了0位置以外"的每一个元素,如果这个元素比'待插入元素大',则后移一位.
            for (; j > 0 && arr[j - 1] > insert; j--) {//考察的位置是0,或者考察的位置满足条件,都退出循环,j就是插入的位置.
                arr[j] = arr[j - 1];
            }
            arr[j] = insert;
        }
    }

    /*
    变化点:
     */
    public void insertSort3(int[] arr, int n) {
        for (int i = 1; i < n; i++) {//i:待插入的元素的索引
            int insert = arr[i];//保留待插入元素的副本.
            //YC: //j:考察insert是不是应该放在j位置,[i,i-1,..1],注意位置0不用考察,直接放置.
            int j = i;
            for (; j > 0; j--) {//考察的位置是0,或者考察的位置是正确的插入位置(前一个元素小)满足条件,都退出循环,j就是插入的位置.
                if (arr[j - 1] > insert) {
                    arr[j] = arr[j - 1];
                } else {
                    //arr[j] = insert; //YC: 此次执行该赋值语句,只能处理第二种退出循环的情况. 如果是考察位置0退出循环,那么赋值语句没有被执行.
                    break;
                }
            }
            arr[j] = insert;//注意
        }
    }

    /*
     思路: 对一个数组进行多次划分,每次划分后,对该次划分后的多个子序列进行插入排序.
     代码分析: 因为用到多个步长一个循环,多个子序列一个循环,插入排序2个循环,共有4个循环.
     */
    public void shellSort(int[] arr, int n) {
        int len = n / 2;//[d/2,..,1]; //i:跳跃分组的每跳一步的步长. //len=1时,就是通常的插入排序.
        while (len > 0) {//对数组按照len进行划分  //len此次划分子序列使用的步长
            //1. 对划分后的多个子序列分别进行插入排序.
            for (int seqNo = 0; seqNo < len; seqNo++) {//seqNo:当前正在处理第seqNo个子序列.
                //2. 对第seqNo序列进行插入排序.
                for (int second = seqNo + len; second < n; second += len) { //从每个子序列的第二个元素开始考察. arr[len]表示第一个子序列的第二个元素.
                    int insert = arr[second]; //insert: 保存待插入元素的副本.
                    int j = second; //j:从后往前考察每个位置是否是insert应该放入的位置. 从子序列第二个元素开始考察. [i,i+len,i+2*len,...]
                    for (; j> seqNo; j = j - len) {
                        if (arr[j - len] > insert) {
                            arr[j] = arr[j - len];
                        } else {
                            break;
                        }
                    }
                    arr[j] = insert;
                }
            }
            len = len/2;
        }
    }


    @Test
    public void testInsertSort() {
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        insertSort(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{4, 3, 3, 2};
        TestUtils.printArray(arr);
        insertSort(arr, arr.length);
        TestUtils.printArray(arr);
    }

    @Test
    public void testInsertSort2() {
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        insertSort2(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{4, 3, 3, 2};
        TestUtils.printArray(arr);
        insertSort2(arr, arr.length);
        TestUtils.printArray(arr);
    }

    @Test
    public void testInsertSort3() {
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        insertSort3(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{4, 3, 3, 2};
        TestUtils.printArray(arr);
        insertSort3(arr, arr.length);
        TestUtils.printArray(arr);
    }

    @Test
    public void testShellSort() {
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        shellSort(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{4, 3, 3, 2};
        TestUtils.printArray(arr);
        shellSort(arr, arr.length);
        TestUtils.printArray(arr);
    }

}



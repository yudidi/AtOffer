package sortingAlgorithm.mergeSort;

import org.junit.jupiter.api.Test;
import sortingAlgorithm.test.TestUtils;

import java.util.Arrays;

/**
 * Created by didi on 15/01/2018.
 */
public class MergeSort {

    public void mergeSort(int[] arr, int n) {
        mergeSortCore(arr, 0, n - 1);
    }

    //对arr[l,r]的元素进行(归并)排序
    public void mergeSortCore(int[] arr, int l, int r) {
        if (l == r || l > r) {
            return;
        }
        int mid = (r + l) / 2;
        mergeSortCore(arr, l, mid);
        mergeSortCore(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

    public void merge(int[] arr, int l, int r, int mid) {
        int[] temp = Arrays.copyOf(arr, arr.length); //temp[l,r]作为新数组.
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {//p1:当前参与合并的第一个数组的第一个元素 //p2:当前参与合并的第二个数组的第一个元素
            if (arr[p1] < arr[p2]) {
                temp[l++] = arr[p1++];
            } else {
                temp[l++] = arr[p2++];
            }
        }
        //把较长数组剩余的元素,直接放入新数组.
        if (p2 > r) {
            while (p1 <= mid) {
                temp[l++] = arr[p1++];
            }
        } else {
            while (p2 <= r) {
                temp[l++] = arr[p2++];
            }
        }
        //把临时数组的值拷贝到原来的数组.
//        arr = Arrays.copyOf(temp, temp.length); //bug //Arrays.copyOf是拷贝引用
        for (int i = 0; i < temp.length; i++) {//correct: for循环逐个拷贝每一个元素.
            arr[i] = temp[i];
        }
    }

    @Test
    public void testMergeSort() {
        //功能测试
        int[] arr = {4, 3, 2, 1};
        TestUtils.printArray(arr);
        mergeSort(arr, arr.length);
        TestUtils.printArray(arr);

        arr = new int[]{3,3,2,1,1};
        TestUtils.printArray(arr);
        mergeSort(arr, arr.length);
        TestUtils.printArray(arr);

        //边界测试
        arr = new int[]{1};
        TestUtils.printArray(arr);
        mergeSort(arr, arr.length);
        TestUtils.printArray(arr);

        //特殊输入测试
        arr = new int[]{};
        TestUtils.printArray(arr);
        mergeSort(arr, arr.length);
        TestUtils.printArray(arr);
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3};
        TestUtils.printArray(arr);
        int[] tmp = Arrays.copyOf(arr, arr.length);
        TestUtils.printArray(tmp);
    }


    @Test
    public void testChangeIntArray() {
        int[] arr = {1, 2, 3};
        System.out.println("使用Arrays.copyOf复制数组,无效");
        changeIntArray1(arr);
        TestUtils.printArray(arr);
        System.out.println("使用arr[i]复制数组元素,有效");
        changeIntArray2(arr);
        TestUtils.printArray(arr);
    }

    public void changeIntArray1(int[] arr) {
        int[] temp = {3, 2, 1};
        arr = Arrays.copyOf(temp, temp.length);
    }

    public void changeIntArray2(int[] arr) {
        int[] temp = {3, 2, 1};
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }

}

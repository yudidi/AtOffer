package 数字在排序数组中出现的次数;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by didi on 11/01/2018.
 */
public class 二分查找 {
    /**
     * @param arr
     * @param n   表示数组中元素的个数
     * @param k
     * @return
     */
    public int 循环(int[] arr, int n, int k) {
        if (n == 0)
            return -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (k > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test循环() {
        System.out.println("循环型二分查找");
        System.out.println("1.功能测试");
        int[] arr = {1, 2, 3};
        assertEquals(-1, 循环(arr, arr.length, 0));
        assertEquals(0, 循环(arr, arr.length, 1));
        assertEquals(1, 循环(arr, arr.length, 2));
        assertEquals(2, 循环(arr, arr.length, 3));
        assertEquals(-1, 循环(arr, arr.length, 4));

        System.out.println("2. 边界值测试");
        arr = new int[]{1, 2, 3};
        System.out.println("2.1 查找最小值");
        int k = 1;
        assertEquals(0, 循环(arr, arr.length, k));
        System.out.println("2.2 查找最大值");
        k = 3;
        assertEquals(2, 循环(arr, arr.length, k));

        System.out.println("2.3 数组中只有一个元素");
        arr = new int[]{1};
        k = 1;
        assertEquals(0, 循环(arr, arr.length, k));
        k = 2;
        assertEquals(-1, 循环(arr, arr.length, k));

        System.out.println("3.特殊输入测试");
        arr = new int[]{};
        k = 1;
        assertEquals(-1, 循环(arr, arr.length, k));
    }


    public int 递归(int[] arr, int l, int r, int k) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (k > arr[mid]) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
        return 递归(arr, l, r, k);
    }

    @Test//功能测试
    public void test递归case1() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + 1 + "的位置是:" + 递归(arr, 0, arr.length - 1, arr[i] + 1));
        }
    }

    //边界值测试
    @Test//查找的值是:最大最小值
    public void test递归case21() {
        int[] arr = {1, 2, 3};
        int k = 1;
        System.out.println(k + "在数组中的位置是:" + 递归(arr, 0, arr.length - 1, k));
        k = 3;
        System.out.println(k + "在数组中的位置是:" + 递归(arr, 0, arr.length - 1, k));
    }

    @Test//数组只有一个值
    public void test递归case22() {
        int[] arr = {1};
        int k = 1;
        System.out.println(k + "在数组中的位置是:" + 递归(arr, 0, arr.length - 1, k));
    }

    @Test//特殊输入测试
    public void test递归case3() {
        int[] arr = {};
        int k = 1;
        System.out.println(k + "在数组中的位置是:" + 递归(arr, 0, arr.length - 1, k));
    }
}

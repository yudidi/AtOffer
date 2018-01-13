package sortingAlgorithm;

import org.junit.jupiter.api.Test;

/**
 * Created by didi on 12/01/2018.
 */
public class BubbleSort {

    //从后往前的冒泡(相邻交换)
    public void bubbleSortByEndToFront(int[] arr,int n){
        //循环不变量:
        // i:表示参与从后往前相邻交换的最后一个元素.
        // j:用于相邻交换,因为是从后往前与前一个元素相邻交换,所以内层循环使用到swap(j-1,j).所以必须保证最后一个j-1刚好是相邻交换的最后一个元素,所以j-1=i;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j-1 >= i; j--) {//j-1: 表示参与相邻交换的最后一个元素,而最后一个元素是i,所以j-1=i;
                if (arr[j-1]>arr[j]){
                    arr[j] = arr[j] ^ arr[j-1];
                    arr[j-1] = arr[j] ^ arr[j-1];
                    arr[j] = arr[j] ^ arr[j-1];
                }
            }
        }
    }

    //从前往后的冒泡(相邻交换)
    public void bubbleSortByFrontToEnd(int[] arr, int n) {
        //循环不变量
        //i:表示参与从前往后相邻交换的最后一个元素,
        //j:用于相邻交换,因为是从前往后与后一个元素相邻交换,所以内层循环使用到swap(j,j+1).所以必须保证最后一个j+1刚好是相邻交换的最后一个元素,j+1=i
        for (int i = n-1; i >0; i--) {
            for (int j = 0; j + 1 <= i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }

    @Test
    public void testBubbleSortByFrontToEnd() {
        int[] arr = {1, 3, 2, 0};
        bubbleSortByFrontToEnd(arr, arr.length);
        printArray(arr);
        arr = new int[]{5,4,3,3,2,2,1,0,1};
        bubbleSortByFrontToEnd(arr, arr.length);
        printArray(arr);
    }

    @Test
    public void testBubbleSortByEndToFront(){
        int[] arr = {1, 3, 2, 0};
        bubbleSortByEndToFront(arr, arr.length);
        printArray(arr);

        arr = new int[]{5,4,3,3,2,2,1,0,1};
        bubbleSortByEndToFront(arr, arr.length);
        printArray(arr);
    }

    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}

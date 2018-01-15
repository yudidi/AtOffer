package sortingAlgorithm.test;

/**
 * Created by didi on 14/01/2018.
 */
public class TestUtils {

    public static void printArray(int[] arr) {
        if (arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

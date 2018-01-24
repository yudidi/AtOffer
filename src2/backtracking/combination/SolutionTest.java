package backtracking.combination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by didi on 24/01/2018.
 */
public class SolutionTest {
    //Functional test
    @Test
    void test1() {
        int[] arr = {1, 2, 3, 4};
        int[][] r = {{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        System.out.println(new Solution().combination(arr,2));
//        assertArrayEquals(r, new Solution().combination(arr, 2).toArray());
    }

    @Test
    void test11() {
        int[] arr = {1, 2, 3, 4};
        int[][] r = {{1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4}};
        System.out.println(new Solution().combination(arr,3));
//        assertArrayEquals(r, new Solution().combination(arr, 3).toArray());
    }

    //Boundary value test
    @Test
    void test2() {
        int[] arr = {1, 2, 3, 4};
        int[][] r = {{1}, {2}, {3}, {4}};
//        assertArrayEquals(r, new Solution().combination(arr, 1).toArray());
        System.out.println(new Solution().combination(arr,1));
    }

    @Test
    void test22() {
        int[] arr = {1, 2, 3, 4};
        int[][] r = {{1, 2, 3, 4}};
//        assertArrayEquals(r, new Solution().combination(arr, 4).toArray());
        System.out.println(new Solution().combination(arr,4));
    }

    //Special input test
    @Test
    void test3SpecialInputOfK() {
        int[] arr = {1, 2, 3, 4};
        int[][] r = {};
        assertArrayEquals(r, new Solution().combination(arr, -1).toArray());
        assertArrayEquals(r, new Solution().combination(arr, 0).toArray());
        assertArrayEquals(r, new Solution().combination(arr, 5).toArray());
    }

    @Test
    void test3SpecialInputOfArray1() {
        int[] arr = null;
        int[][] r = {};
        assertArrayEquals(r, new Solution().combination(arr, 2).toArray());
    }

    @Test
    void test3SpecialInputOfArray2() {
        int[] arr = {};
        int[][] r = {};
        assertArrayEquals(r, new Solution().combination(arr, 2).toArray());
    }
}

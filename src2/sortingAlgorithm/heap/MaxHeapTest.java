package sortingAlgorithm.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by didi on 17/01/2018.
 */
public class MaxHeapTest {
    @Test
    void testInsert() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(5);
        for (int i = 0; i < 10; i++) {
            maxHeap.insert(new Random().nextInt(100));
        }
        System.out.println(maxHeap);
    }

    @Test
    void testListAdd(){
        List<Integer> list = new ArrayList<>();
        list.add(0,100);
        list.add(3,300);//bug
        System.out.println(list);
    }

    @Test
    void testPopHeadBug1(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>(5);
        int[] arr = {-1, 99, 96, 88, 65, 69, 10, 4, 5, 24, 11};//bug: 没有检查当前节点是否>=较大的子节点,如果是则退出循环
        for (int i = 1; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        System.out.println(maxHeap);
        while (!maxHeap.isEmpty()){
            System.out.print(" "+maxHeap.popMax());
        }
    }

    @Test
    void testPopHead(){
        MaxHeap<Integer> maxHeap = new MaxHeap<>(5);
        for (int i = 0; i < 10; i++) {
            maxHeap.insert(new Random().nextInt(100)+1);
        }
        System.out.println(maxHeap);
        while (!maxHeap.isEmpty()){
            System.out.print(" "+maxHeap.popMax());
        }
    }

}

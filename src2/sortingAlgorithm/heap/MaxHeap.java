package sortingAlgorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by didi on 17/01/2018.
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * data[1..count]用于存放堆中元素. //使得==>元素在存储结构中的索引==元素在逻辑结构中的编号(按层次编号)
     */
    private List<E> data;
    /**
     * 堆中存在的元素个数.
     * 堆的最后一个元素的索引.
     */
    private int count;

    public MaxHeap(int capacity) {
        this.data = new ArrayList<E>(capacity + 1);
        this.count = 0;
        this.data.add(null);
    }

    /*
    传入一个数组,构造成堆.
     */
    public MaxHeap(List<E> arr,int n){
        this.data = new ArrayList<E>(n+1);
        this.data.add(null);
        this.data.addAll(arr);
        this.count = n;

        for (int i = count/2; i >=1 ; i--) {//i: 当前考察的非叶子节点.
            //shiftDown
            int j = i;
            while (2*j<=count){
                int big = 2 * j;
                if (big+1<=count && data.get(big+1).compareTo(data.get(big))>0){
                    big = big +1;
                }
                if (data.get(j).compareTo(data.get(big))>=0)
                    break;
                swapByTmp(j,big);
                j = big;
            }
        }
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 层序遍历
     * TODO
     * @return
     */
    public void printMaxHeapByLevel() {

    }

    @Override
    public String toString() {
        return data.toString();
    }

    public void insert(E e) {
        data.add(++count, e);
        int i = count; //[0,1,e] //i:插入的数的下标
        while (i > 1 && data.get(i).compareTo(data.get(i / 2)) > 0) {
            swapByTmp(i, i / 2);
            i = i / 2;
        }
    }

    public E popMax() {
        if (count == 0) {
            return null;
        }

        E r = data.get(1);

        swapByTmp(1, count);
        count--;//count: 堆中最后一个元素的索引. //堆中元素减一.

        int i = 1; //i: 当前处理的元素
        while (2 * i <= count) {  //只有还有一个子节点,就要继续考察当前元素i.
            int big = 2 * i;
            if (big + 1 <= count && data.get(big + 1).compareTo(data.get(big)) > 0) {
                big = big + 1;
            }
            if (data.get(i).compareTo(data.get(big))>=0)
                break;
            swapByTmp(i, big);
            i = big;
        }
        return r;
    }

    private void swapByTmp(int a, int b) {
        E tmp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, tmp);
    }


}

package _20171212调整数组顺序使奇数位于偶数前面;

public class Solution {
	public void reOrderArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) // 前偶后奇交换
				{
					array[j] = array[j] ^ array[j - 1];
					array[j - 1] = array[j] ^ array[j - 1];
					array[j] = array[j] ^ array[j - 1];
				}
			}
		}

	}
}

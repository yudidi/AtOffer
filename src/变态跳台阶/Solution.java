package ��̬��̨��;

/**
 * ˼·: ���ݷ������ԭ��: ����ÿ�����������һ��,���Դ�����̨����,��ô fn = f(1) + f(2) + .... + f(n-1) +
 * f(0). f(0)��ʾֱ����n��̨�� f(1)��ʾ��1���� f(2)��ʾ��2���� f(n-1)��ʾ��n-1����. �������������������������.
 * 
 * @author didi
 * 
 */
public class Solution {

	public int JumpFloorII(int target) {
		int[] temp = new int[target + 1];
		temp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < i; j++) {
				temp[i] += temp[j];
			}
		}
		return temp[target];
	}
}

/**
 * �ؼ�: �л�ԭ���ĽǶ�,ȥ˼��.
 * 
 * ÿ��̨�׶������벻������������������һ��̨�ף������һ��̨�ױ����������Թ���2^(n-1)�����
 * http://blog.csdn.net/xiaochunyong/article/details/7748713
 * @author didi
 * 
 */
class Solution2 {
	public int JumpFloorII(int target) {
		return 1 << --target;
	}
}
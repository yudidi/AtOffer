package ��̨��;

public class Solution {

	  public static int JumpFloor(int target) {
		  /**
	         * ���ƹ�ʽ: fn = f(n-1)+f(n-2); //����ӷ�����: �����1��+�����2��,����
	         * ���Ƴ���: f1 = 1, f2 = 2
	         * 
	         */
	        if(target == 0 || target == 1){
	            return 1;
	        }
	        return JumpFloor(target-1) + JumpFloor(target-2);
	    }
	  
	  //��¼�ݹ�����м���Ľ��,�����ظ�����.
	  public int JumpFloor2(int target) {
	        if(target == 0 || target == 1){
	            return 1;
	        }
	        if (target == 2) {
				return 2;
			}
	        int[] temp =new int[target+1];
	        temp[1] = 1;
	        temp[2] = 2;
	        for (int i = 3; i <= target; i++) {
				temp[i] = temp[i-1]+temp[i-2];
			}
			return temp[target];
	    }
}

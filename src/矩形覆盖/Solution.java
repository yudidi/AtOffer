package 矩形覆盖;

/**
 * //YC: RectCover31()数组越界,只能通过多个If语句进行判断和赋值RectCover4.
 * @author didi
 *
 */
public class Solution {
	/**
	 * Two error understandings:
	 * 1. what can be considered as a placement, I shouldn't consider the different of each rectangle.
	 *    I should consider the position of each rectangle of each placement.
	 * 2. 
	 * @param target
	 * @return
	 */
	public int RectCover(int target) {
		if (target == 0) {
			return 0;
		}
		int[] results = new int[target + 1];
		results[1] = 1;
		for (int i = 2; i <= target; i++) {
			results[i] = i * results[i - 1];
		}
		return results[target];
	}
	
	public int RectCover2(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return RectCover2(target-1)+RectCover2(target-2);
	}
	
	public int RectCover3(int target) {
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		
		int[]  results = new int[target+1];
		results[1] =1;
		results[2] =2;
		for (int i = 3; i <=target; i++) {
			results[i] = results[i-1]+results[i-2];
		}
		return results[target];
	}
	
	//YC: RectCover31()数组越界,只能通过多个If语句进行判断和赋值RectCover4.
	public int RectCover31(int target) {
		int[]  results = new int[target+1];
		results[0] =0;
		results[1] =1;
		results[2] =2;
		for (int i = 3; i <=target; i++) {
			results[i] = results[i-1]+results[i-2];
		}
		return results[target];
	}
	
	public int RectCover4(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		
		int[]  results = new int[target+1];
		results[1] =1;
		results[2] =2;
		for (int i = 3; i <=target; i++) {
			results[i] = results[i-1]+results[i-2];
		}
		return results[target];
	}
	
	public static void main(String[] args) {
		for (int j = 0; j < 20; j++) {
			System.out.println(j+ ":"+new Solution().RectCover31(j));
		}
		
	}
	
}



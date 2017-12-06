package ±äÌ¬ÌøÌ¨½×;

public class Solution {

	 public int JumpFloorII(int target) {
	        int[] temp = new int[target+1];
	        temp[0] = 1;
	        for(int i = 1;i<=target;i++){
	            for(int j = 0;j<i;j++){
					temp[i] += temp[j];                
	            }
	        }
	        return temp[target];
	    }
}

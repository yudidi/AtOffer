package ios._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//根据上排给出的10个数,在其下排填出对应的10个数
//要求下排对应的数字是上排对应的数字在下排出现的次数之和
//上排数值如下:{0,1,2,3,4,5,6,7,8,9}
//比如：
//上排数值:{0,1,2,3,4,5,6,7,8,9}
//下排分配:{6,2,1,0,0,0,1,0,0,0}
//Q: 列出所有这样的下排数字组合

public class One {

	public static void main(String[] args) {
		int[] a= {0,1,2,3,4,5,6,7,8,9};
	}
	
	public static List<Integer> results = new ArrayList<>();
	
	
	public static void allocate(int[] restArr,Integer restTime,List<List<Integer>> results) {
		//限制条件
		//1. 上排0->下排不能是0; 下排0,上排不能是0;
		//2. 下排数字和=10
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < restArr.length; i++) {//i是当前分配的数字的下标,i不能超过剩余未分配数字的个数
			for (int j = 0; j <=restTime; j++) {//j是分配的次数,需要<=restTime
				if (i==0 && j==0) {
					continue;
				}
				result.add(j);
			}
		}
		results.add(result);
	}
	
	
	
	
	
}

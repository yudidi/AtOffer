package ios._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//�������Ÿ�����10����,�������������Ӧ��10����
//Ҫ�����Ŷ�Ӧ�����������Ŷ�Ӧ�����������ų��ֵĴ���֮��
//������ֵ����:{0,1,2,3,4,5,6,7,8,9}
//���磺
//������ֵ:{0,1,2,3,4,5,6,7,8,9}
//���ŷ���:{6,2,1,0,0,0,1,0,0,0}
//Q: �г����������������������

public class One {

	public static void main(String[] args) {
		int[] a= {0,1,2,3,4,5,6,7,8,9};
	}
	
	public static List<Integer> results = new ArrayList<>();
	
	
	public static void allocate(int[] restArr,Integer restTime,List<List<Integer>> results) {
		//��������
		//1. ����0->���Ų�����0; ����0,���Ų�����0;
		//2. �������ֺ�=10
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < restArr.length; i++) {//i�ǵ�ǰ��������ֵ��±�,i���ܳ���ʣ��δ�������ֵĸ���
			for (int j = 0; j <=restTime; j++) {//j�Ƿ���Ĵ���,��Ҫ<=restTime
				if (i==0 && j==0) {
					continue;
				}
				result.add(j);
			}
		}
		results.add(result);
	}
	
	
	
	
	
}

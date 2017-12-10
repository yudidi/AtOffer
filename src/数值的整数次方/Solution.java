package ��ֵ�������η�;

//����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
/**
 * TODO: Ϊʲô��logn��ʱ�临�Ӷ�.
 * @author didi
 *
 */
public class Solution {
	
	//�ӵ�λ����λ,��λ��ֵ��1�������Ȩֵ�۳�. Ȩֵ����ͨ��>>1��ʵ��.
	public double Power(double base, int exponent) {
		// 1. �ų��������
		if (base == 0) {
			throw new RuntimeException("��������Ϊ0");	
		}
		//2. 10^5 == 10^001 * 1o^100
		int valueOfPos = 1 * 10; // 10 --> 10*10 --> 100*100.
		int result = 1;//�����۳�λ����1��Ȩֵ.
		while (exponent != 0) {//Test: 10 ^1, 10 ^2.
			if ((exponent & 1) == 1) {
				result = result * valueOfPos;
			}
			exponent = exponent >> 1;
			valueOfPos = valueOfPos * valueOfPos; 
		}
		return result;  
	}
	
	//Fix bug: û�п���exponent<0����� 10^2 ��  10^-2��Ϊ����.
	 public double Power2(double base, int exponent) {
	      	if (base == 0) {
				throw new RuntimeException("��������Ϊ0");	
			}
	      	//10^5
			double valueOfPos = 1 * base; //YC:Ȩֵ�ĸı�·��:  10 --> 10^2 --> 10^2^2  == 10^0001 ->10^0000 -> 10^0000 -> 10^1000;
			double result = 1;//�����۳�λ����1��Ȩֵ.
			while (exponent != 0) {//Test: 10 ^1, 10 ^2
				if ((exponent & 1) == 1) {
					result = result * valueOfPos;
				}
				exponent = exponent >> 1;
				valueOfPos = Math.pow(valueOfPos, 2); // valueOfPos * valueOfPos //Ȩֵ������ָ������. 
			}
			return exponent>=0? result : (1/result);
	  }
	 
	 //fix bug: ���ָ���Ǹ���, �Ȱ�����������,�����ȡ����.
	 //fix bug: base��������Ϊ0.
	 //fix bug: ��ѭ���л��޸ĵı���ʹ����ʱ������������, ����return�е��������.
	 public double Power3(double base, int exponent) {
	      	int n = exponent;
	      	if (n < 0) {
				n = -n;
			}
	      	//10^3 , 10^-3
			double valueOfPos = 1 * base; //YC:Ȩֵ�ĸı�·��:  10 --> 10^2 --> 10^2^2  == 10^0001 ->10^0000 -> 10^0000 -> 10^1000;
			double result = 1;//�����۳�λ����1��Ȩֵ.
			while (n != 0) {//Test: 10 ^1, 10 ^2
				if ((n & 1) == 1) {
					result = result * valueOfPos;
				}
				n = n >> 1;
				valueOfPos = Math.pow(valueOfPos, 2); // valueOfPos * valueOfPos //Ȩֵ������ָ������. 
			}
			return exponent>=0 ? result : (1/result);
	  }
	 
	 public static void main(String[] args) {
		 for (int i = -3; i < 3; i++) {
				System.out.println(i+" : "+new Solution().Power3(10, i));
		}
	}

}

package 数值的整数次方;

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
/**
 * TODO: 为什么是logn的时间复杂度.
 * @author didi
 *
 */
public class Solution {
	
	//从低位到高位,把位置值是1所代表的权值累乘. 权值增长通过>>1来实现.
	public double Power(double base, int exponent) {
		// 1. 排除基本情况
		if (base == 0) {
			throw new RuntimeException("底数不能为0");	
		}
		//2. 10^5 == 10^001 * 1o^100
		int valueOfPos = 1 * 10; // 10 --> 10*10 --> 100*100.
		int result = 1;//不断累乘位上是1的权值.
		while (exponent != 0) {//Test: 10 ^1, 10 ^2.
			if ((exponent & 1) == 1) {
				result = result * valueOfPos;
			}
			exponent = exponent >> 1;
			valueOfPos = valueOfPos * valueOfPos; 
		}
		return result;  
	}
	
	//Fix bug: 没有考虑exponent<0的情况 10^2 和  10^-2互为倒数.
	 public double Power2(double base, int exponent) {
	      	if (base == 0) {
				throw new RuntimeException("底数不能为0");	
			}
	      	//10^5
			double valueOfPos = 1 * base; //YC:权值的改变路径:  10 --> 10^2 --> 10^2^2  == 10^0001 ->10^0000 -> 10^0000 -> 10^1000;
			double result = 1;//不断累乘位上是1的权值.
			while (exponent != 0) {//Test: 10 ^1, 10 ^2
				if ((exponent & 1) == 1) {
					result = result * valueOfPos;
				}
				exponent = exponent >> 1;
				valueOfPos = Math.pow(valueOfPos, 2); // valueOfPos * valueOfPos //权值是以现指数增加. 
			}
			return exponent>=0? result : (1/result);
	  }
	 
	 //fix bug: 如果指数是负数, 先按照整数处理,最后再取倒数.
	 //fix bug: base底数可以为0.
	 //fix bug: 把循环中会修改的变量使用临时变量保存起来, 用于return中的条件语句.
	 public double Power3(double base, int exponent) {
	      	int n = exponent;
	      	if (n < 0) {
				n = -n;
			}
	      	//10^3 , 10^-3
			double valueOfPos = 1 * base; //YC:权值的改变路径:  10 --> 10^2 --> 10^2^2  == 10^0001 ->10^0000 -> 10^0000 -> 10^1000;
			double result = 1;//不断累乘位上是1的权值.
			while (n != 0) {//Test: 10 ^1, 10 ^2
				if ((n & 1) == 1) {
					result = result * valueOfPos;
				}
				n = n >> 1;
				valueOfPos = Math.pow(valueOfPos, 2); // valueOfPos * valueOfPos //权值是以现指数增加. 
			}
			return exponent>=0 ? result : (1/result);
	  }
	 
	 public static void main(String[] args) {
		 for (int i = -3; i < 3; i++) {
				System.out.println(i+" : "+new Solution().Power3(10, i));
		}
	}

}

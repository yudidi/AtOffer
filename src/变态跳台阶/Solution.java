package 变态跳台阶;

/**
 * 思路: 根据分类计数原理: 考虑每种跳法的最后一跳,可以从任意台阶跳,那么 fn = f(1) + f(2) + .... + f(n-1) +
 * f(0). f(0)表示直接跳n个台阶 f(1)表示从1起跳 f(2)表示从2起跳 f(n-1)表示从n-1起跳. 所有情况加起来就是跳发总数.
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
 * 关键: 切换原来的角度,去思考.
 * 
 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
 * http://blog.csdn.net/xiaochunyong/article/details/7748713
 * @author didi
 * 
 */
class Solution2 {
	public int JumpFloorII(int target) {
		return 1 << --target;
	}
}
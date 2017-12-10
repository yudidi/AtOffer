package test;

import java.util.ArrayList;
import java.util.List;

public class Test²¹Âë {
	public static void main(String[] args) {
		
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(-1);
		ints.add(-2);
		ints.add(-3);
		for (int i = 0; i < ints.size(); i++) {
//			System.out.println(Integer.toBinaryString(ints.get(i)));
			System.out.println(ints.get(i));
		}
	}
	/** output
	1
	10
	11
	11111111111111111111111111111111
	11111111111111111111111111111110
	11111111111111111111111111111101
	 */
}

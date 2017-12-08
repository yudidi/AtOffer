package test;

import java.util.ArrayList;

public class TestListAndNull {
 public static void main(String[] args) {
	
	 ArrayList<Integer> list = new ArrayList<Integer>();
	 list.add(null);
	 list.add(null);
	 
	 for (Integer integer : list) {
		System.out.println(integer);
	}
}
}

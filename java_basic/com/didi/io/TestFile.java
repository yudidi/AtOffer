package com.didi.io;

import java.io.File;

public class TestFile {

	public static void main(String[] args) {
		File file1 = new File("d:\\io\\helloworld.txt");
		File file11 = new File("d:/io/helloworld.txt");
		File file2 = new File("hello.txt");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file11.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
	}
	
}

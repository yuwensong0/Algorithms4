package chapter1_2;

import java.io.*;

public class PrintFileList {
	public static void go(File f) {
		go(f, 0);
	}
	
	private static void go(File f, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.println(f.getName());
		if (f.isDirectory()) {
			for (File af : f.listFiles()) {
				go(af, depth + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/Games");
		go(f);
	}
}

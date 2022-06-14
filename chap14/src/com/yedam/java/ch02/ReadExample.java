package com.yedam.java.ch02;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("D:/dev/temp/test7.txt");

		while (true) {
			int data = reader.read();
			if (data == -1)
				break;
			System.out.println((char) data);
		}

		reader.close();
		System.out.println("--------------------");

		reader = new FileReader("D:/dev/temp/test8.txt");

		char[] buffer = new char[2];
		while(true) {
			int readCharNum = reader.read(buffer);
			if(readCharNum == -1) break;
			for (int i = 0; i < readCharNum; i++) {
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		reader.close();
		
		System.out.println("--------------------");

		reader = new FileReader("D:/dev/temp/test10.txt");
		
		int readCharNum = reader.read(buffer,5,10);
		for(int i = 0; i < 5+readCharNum; i++) {
			System.out.println(buffer[i]);
		}
		reader.close();


	}

}

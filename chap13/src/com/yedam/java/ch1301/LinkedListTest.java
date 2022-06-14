package com.yedam.java.ch1301;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long start;
		long end;
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayList 걸린시간 : " + (end - start) + "ns");
		
		/////////////////////////////
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (end - start) + "ns");
		
		
		
		

	}
}

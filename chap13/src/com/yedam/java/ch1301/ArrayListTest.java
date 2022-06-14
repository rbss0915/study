package com.yedam.java.ch1301;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Java");		//0
		list.add("JDBC");		//1
		list.add("Servlet/JSP");	//2 -> 3
		list.add(2, "Database");	//2지정 밀어냄
		list.add("iBATIS");	//4
		
		System.out.println("총 객체 수 : " + list.size());
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ":" + list.get(i));
		}

	///
		System.out.println();
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		System.out.println();
		for(String data : list) {
			System.out.println((data));
		}
		
	}

}

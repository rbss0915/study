package com.yedam.java.ch1301;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		//List<Integer> list = new ArrayList<>();// 어레이는 오류
		List<String> list = new Vector<>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
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

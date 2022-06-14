package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		//set.add(new String("Java"));
		set.add("iBATIS");
		
		System.out.println("총 객체수 : " + set.size());	//5개넣는데 중복빼고 4개
		System.out.println();
		
		//반복자
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println();
		
		//제거
		set.remove("JDBC");
		set.remove("iBATIS");
		
		for(String data : set) {
			System.out.println(data);
		}
		System.out.println();
		set.clear();
		if(set.isEmpty()) {
			System.out.println("비어있음.");
		}
		

	}
}

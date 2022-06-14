package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		String data1 = "Java";
		String data2 =  new String("Java");
		
		if(data1 == data2) {
			System.out.println("서로 같은 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		//set컬렉션에 넣으면
		Set<String> set = new HashSet<>();
		set.add(data1);
		set.add(data2);
		
		System.out.println("총객체수 :" + set.size());
		
		
	}

}

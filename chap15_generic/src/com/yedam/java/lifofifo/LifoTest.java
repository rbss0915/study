package com.yedam.java.lifofifo;

import java.util.Stack;

public class LifoTest {
	public static void main(String[] args) {
		Stack<Integer> box = new Stack<>();
		
		box.push(100);
		box.push(50);
		box.push(100);
		box.push(10);
		
		while(!box.isEmpty()) {
			int value = box.pop();
			System.out.println("box 값:"+box.size());
			System.out.println("꺼내온값:"+value);
		}
	}

}


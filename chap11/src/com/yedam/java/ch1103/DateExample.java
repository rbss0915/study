package com.yedam.java.ch1103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);	//양식안맞음
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		String result = sdf.format(now);
		String result2 = sdf.format(new Date());
		System.out.println(result);
		System.out.println(result2);

	}

}

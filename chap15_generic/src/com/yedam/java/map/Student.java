package com.yedam.java.map;

public class Student {
	
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		
		return sno + name.hashCode();	//이름 값이 같으면 동일하게 인식하게
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {		//같은 타입인지 확인
			Student s = (Student) obj;	//강제타입변환
			return(sno == s.sno) && (name.equals(s.name));
		}
		return super.equals(obj);
	}

}

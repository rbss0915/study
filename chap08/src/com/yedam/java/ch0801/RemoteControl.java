package com.yedam.java.ch0801;

public interface RemoteControl {			//인터페이스 스테틱파이널 보이드,업스트렉트 일반거처럼 해주지만, 차이 인식은 해야됨/자바가 채.워.주.는.거
	//상수 필드
	public static final int MAX_VOLUME = 10;
	//public int MIN_VOLUME;	//인터페이스는 상수!
	public int MIN_VOLUME = 0;
	
	//추상메소드
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	/*
//원래 인터페이스에선 어긋남. 자바11되면서 추가된 기능. 많이 안씀 그러려니
	//일반 메소드
	public default void show() {	//디폴트 어거지로 끼워넣음
		System.out.println("추가한 메소드");
	}
	//정적 메소드
	*/
}
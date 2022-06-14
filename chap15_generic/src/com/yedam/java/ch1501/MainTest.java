package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		bag.set(new Note());
		String name = (String)bag.get();//리턴되는 타입이 오브젝트라서 앞에타입 
		
		bag.set("신운하");
		Note note = (Note)bag.get();
		// 제네릭 이유 버전 5부터나옴 : 1.겟 값꺼내올떄마다 타입변환 부담됨. 
							//2.모든걸 받는다는건 꺼낼때 타입이 확실할지 오류가능성
		
		Box<Note, String, Integer> box = new Box<>();
		
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();		//타입변환없이 사용가능.
		
		
		
		///////////////////////////////////////////////
		Box<Car, Bus, Taxi> venhicle = new Box<>();
		venhicle.setT(new Car());
		venhicle.setV(new Bus());
		venhicle.setK(new Taxi());
		
		Car car = venhicle.getT();
		Bus bus = venhicle.getV();
		Taxi taxi = venhicle.getK();
	}

}


class Car{}
class Bus{}
class Taxi{}
package homework0603;

public class ObesityInfo extends StandardWeightInfo  {

	String result = "";
	String name = Human.name;
	int weight = Human.weight;
	int height = Human.height;
	double standard = Human.standard;

	public String getObesity() {
		bmi = (weight - standard)/standard*100;
		
		if(bmi<=18.5) {
			result = "저체중";
		}else if (18.5<bmi && bmi<23.0) {
			result = "정상";
		}else if (23.0<=bmi && bmi<25.0) {
			result = "과체중";
		}else if (25.0<=bmi) {
			result = "비만";
		}else {
			result = "측정오류";
		}
		return result;
	}
	
	@Override
	public void getInformation() {
	System.out.println(name + "님의 신장" + height + ", 몸무게" + weight + ", " + result + "입니다.");

	}

	
}

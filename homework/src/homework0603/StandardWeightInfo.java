package homework0603;

public class StandardWeightInfo extends Human{


	@Override
	public void inputInfo() {
		super.inputInfo();
	}

	public double getStandardWeight() {
		standard = (height - 100) * 0.9;
		return standard;
	}

	@Override
	public void getInformation() {
		System.out.println(name + "님의 신장" + height + ", 몸무게" + weight + ", 표준체중은 " + standard + "입니다.");
	}
	


	

}

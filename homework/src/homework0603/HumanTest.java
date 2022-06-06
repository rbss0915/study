package homework0603;

public class HumanTest {

	public static void main(String[] args) {
		
		StandardWeightInfo standard = new StandardWeightInfo();
		standard.inputInfo();
		standard.getStandardWeight();
		standard.getInformation();
		
		ObesityInfo obersity = new ObesityInfo();
		obersity.getObesity();
		obersity.getInformation();

	}

}

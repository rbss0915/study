package homework0603;

public class AcadeGame implements Keypad {
	int mode = 0;
	AcadeGame(){}

	@Override
	public void leftUpButton() {
		System.out.println("########## 캐릭터가 앞쪽으로 이동한다 ##########");
			}

	@Override
	public void leftDownButton() {
		System.out.println("########## 캐릭터가 뒤쪽으로 이동한다 ##########");
	}

	@Override
	public void rightUpButton() {
		if(mode == 0) {
			System.out.println("########## 캐릭터가 일반 공격 ##########");
		}else if(mode == 1) {
			System.out.println("########## 캐릭터가 연속 공격 ##########");
		}
	}

	@Override
	public void rightDownButton() {
		if(mode == 0) {
			System.out.println("########## 캐릭터가 HIT 공격 ##########");
		}else if(mode == 1) {
			System.out.println("########## 캐릭터가 Double HIT 공격 ##########");
		}
	}

	@Override
	public void changeMode(){
		if(mode == Keypad.NORMAL_MODE) {
			System.out.println("--------------------");
			System.out.println(" NORMAL MODE FINISH ");
			System.out.println("--------------------");
			System.out.println("");
			System.out.println("");
			mode = mode+1;
		}else if(mode == Keypad.HARD_MODE) {
			System.out.println("--------------------");
			System.out.println("  HARD MODE FINISH  ");
			System.out.println("--------------------");
			System.out.println("");
			System.out.println("");
			mode = mode-1;
		}
	}

}

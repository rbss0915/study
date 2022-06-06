package homework0603;

public class RPGGame implements Keypad {
	int mode = 0;
	
	@Override
	public void leftUpButton() {
		System.out.println("########## 캐릭터가 위쪽으로 이동한다 ##########");
			}

	@Override
	public void leftDownButton() {
		System.out.println("########## 캐릭터가 아래쪽으로 이동한다 ##########");
	}

	@Override
	public void rightUpButton() {
		if(mode == 0) {
			System.out.println("########## 캐릭터가 한칸단위로 점프한다 ##########");
		}else if(mode == 1) {
			System.out.println("########## 캐릭터가 두칸단위로 점프한다 ##########");
		}
	}

	@Override
	public void rightDownButton() {
		if(mode == 0) {
			System.out.println("########## 캐릭터가 일반 공격 ##########");
		}else if(mode == 1) {
			System.out.println("########## 캐릭터가 HIT 공격 ##########");
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

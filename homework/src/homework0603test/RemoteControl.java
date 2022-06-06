package homework0603test;

public interface RemoteControl {
	// 상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 10;

	// 추상 메소드
	public void turnOn();

	public void turnOff();

	public void setVolume(int Volume);

	// 디폴트 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}

  // 정적 메소드
	static void changeBettery() {
		System.out.println("건전지를 교환합니다.");
	}
}
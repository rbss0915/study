package homework0603test;

public class RemoteControlMain {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl() {
			public void turnOn() {
				System.out.println("1turnOn");
			}
			public void turnOff() {
				System.out.println("turnOff");
			}
			public void setVolume(int volume) {
				System.out.println("setVolume");
			}
		};
	}
}
package coupling;

public class TVUser {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

		LgTV tv2 = new LgTV();
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
	}
}

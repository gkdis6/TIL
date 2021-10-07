package factory;

public class TVUser {

	public static void main(String[] args) {
		TV tv = BeanFactory.getBean(args[0]);
		tv.powerOff();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
	}

}

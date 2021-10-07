package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV {

	@Autowired
	private AppleSpeaker speaker; 
	
	@Value("400000")
	private int price;
	
	public SamsungTV() {
		System.out.println(">>>SamsungTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("SamsungTV...전원을 켠다.(가격:"+price+")");

	}

	public void powerOff() {
		System.out.println("SamsungTV...전원을 끈다.");

	}

	public void volumeUp() {
		speaker.volumeUp();

	}

	public void volumeDown() {
		speaker.volumeDown();

	}
	

}

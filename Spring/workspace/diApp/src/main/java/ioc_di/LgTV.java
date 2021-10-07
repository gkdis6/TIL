package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV{

	@Autowired
	private AppleSpeaker speaker;
	@Value("500000")
	private int price;
	
	public LgTV() {
	    System.out.println(">>>> LgTV 객체 생성");
	  }
	
	public void powerOn() {
		System.out.println("LgTV...전원을 켠다.(가격:"+price+")");
		
	}

	public void powerOff() {
		System.out.println("LgTV...전원을 끈다.");
		
	}

	public void volumeUp() {
		speaker.volumeUp();
		
	}

	public void volumeDown() {
		speaker.volumeDown();
		
	}

}

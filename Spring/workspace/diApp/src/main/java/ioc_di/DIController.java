package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DIController {

	@Autowired
	@Qualifier("samsungTV")
	TV tv;
	
	@Autowired
	@Qualifier("lgTV")
	TV tv2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		//1. samsungTV Bean 가져오기
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//2. lgTV Bean 가져오기
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
	
		return "Annotation DI 사용하기";
	}

}

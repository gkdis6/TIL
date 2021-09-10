package day06;

interface Green {
	// 추상 메소드
	public String greenColor();
}

class GreenImpl implements Green {
	public String greenColor() {
		return "초록색입니다.★";
	}
}

interface Red {
	// 추상 메소드
	public String redColor();
}

class RedImpl implements Red {
	public String redColor() {
		return "빨간색입니다.★";
	}
}

class ColorImpl implements Green, Red {
	public String greenColor() {
		return "초록색입니다.";
	}

	public String redColor() {
		return "빨간색입니다.";
	}
}

public class ColorMain {
	public static void main(String[] args) {
		Green g = new GreenImpl();
		System.out.println(g.greenColor());

		Red r = new RedImpl();
		System.out.println(r.redColor());

		ColorImpl c = new ColorImpl();
		System.out.println(c.greenColor());
		System.out.println(c.redColor());
	}
}
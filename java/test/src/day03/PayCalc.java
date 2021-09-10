package day03;

class Pay {
	private String name;
	private int bonbong;

	public Pay() {}
	
	public Pay(String str, int i) {
		name = str;
		bonbong = i;
	}

	public void setName(String str) {
		name = str;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBonbong(int n) {
		bonbong = n;
	}
	
	public int getBonbong() {
		return bonbong;
	}
	
	public int taxCalc() {
		return (int) (bonbong * 0.045 + 0.5);
	}

	public int silsuCalc() {
		return bonbong - taxCalc();
	}

	public void printCalc() {
		System.out.println("--------------------");
		System.out.println("---8월 급여 내역---");
		System.out.println("--------------------");
		System.out.println("성명: " + name);
		System.out.println("본봉: " + bonbong);
		System.out.println("세금: " + taxCalc());
		System.out.println("실수령액: " + silsuCalc());
	}
}

class ExtraPay extends Pay{
	private int year;
	private int child;
	
	ExtraPay(){}
	ExtraPay(String name, int bonbong, int year, int child){
		super(name, bonbong);
		this.year = year;
		this.child = child;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	
	public int getExtraPay() {
		int pay = 0; // 초봉 기본급

		if (year == 0) {
			System.out.println("신입사원입니다.");
		} else if (year == 1) {
			pay = 200000*year;
			System.out.println("경력 1년 입니다.");
		} else if (year == 2) {
			pay = 200000*year;
		} else if (year == 3) {
			pay = 200000*year;
		} else if (year == 4) {
			pay = 200000+year;
		} else {
			pay += 1500000;
		}

		// 자녀수당을 계산합니다.
		if (year >= 1) {
			if (child > 1) pay += (child * 200000);
		}
		
		return pay;
	}
	@Override
	public void printCalc() {
		System.out.println("성명: " + getName());
		System.out.println("본봉: " + getBonbong());
		System.out.println("세금: " + taxCalc());
		System.out.println("수당: " + getExtraPay());
		System.out.println("실수령액: " + (silsuCalc()+getExtraPay()));
	}
	
}

public class PayCalc {

	public static void main(String[] args) {
		Pay p1 = new Pay();
		Pay p2 = new Pay();
		Pay p3 = new Pay();
		Pay p4 = new Pay("홍길동", 4000000);

		p1.setBonbong(2000000); // 200만원
		p1.setName("왕눈이");

		p2.setBonbong(2500000); // 200만원
		p2.setName("아로미");
		
		p3.setBonbong(1500000); // 200만원
		p3.setName("투투");


		p1.printCalc();
		p2.printCalc();
		p3.printCalc();
		
		ExtraPay ep = new ExtraPay();
		ep.setName("김길동");
		ep.setBonbong(3000000);
		ep.setYear(3);
		ep.setChild(2);
		ep.printCalc();
	}
}

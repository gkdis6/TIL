package day04;

class SchoolVO {
	String name = "";
	int kuk = 0;
	int eng = 0;
	int tot = 0;
	int avg = 0;
}

class SchoolProc2 {
	public void print(SchoolVO vo) {
		System.out.println("vo.name: " + vo.name);
		System.out.println("vo.kuk : " + vo.kuk);
		System.out.println("vo.eng : " + vo.eng);
		System.out.println("vo.tot : " + vo.tot);
		System.out.println("vo.avg : " + vo.avg);
	}
}

public class SchoolUse2 {

	public static void main(String[] args) {
		SchoolVO vo = new SchoolVO();
		vo.name = "가길동";
		vo.kuk = 85;
		vo.eng = 80;
		vo.tot = 165;
		vo.avg = 82;

		SchoolProc2 sp = new SchoolProc2();
		sp.print(vo); // Call By Reference

	}

}

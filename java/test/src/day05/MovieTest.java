package day05;

class Movie {
	String prat = "영화";
}

class Korea extends Movie { // part변수 상속
	String m1 = "가문의위기";
}

class Foreign extends Movie {
	String m1 = "박물관이 살아있다.";
}

public class MovieTest {
	public static void main(String[] args) {
		Korea k = new Korea();
		System.out.println("장르:" + k.prat);
		System.out.println("제목:" + k.m1);
		Foreign f = new Foreign();
		System.out.println("장르:" + f.prat);
		System.out.println("제목:" + f.m1);
	}

}

package day04;

class Code {
	public String getArea(int index) { // Call By Value
		// 1차원 배열
		String[] areas = { "서울", "천안", "대전", "대구", "광주", "강릉" };
		// 0 1 2 3 4 5

		return areas[index - 1]; // String return
	}
}

public class CodeUse {

	public static void main(String[] args) {
		Code co = new Code();
		String area = co.getArea(6);

		System.out.println(area);

	}

}

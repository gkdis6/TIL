package day02;

public class SwitchEx02 {

	public static void main(String[] args) {
		int score = 100;
		
		switch (score/10) {
		case 10, 9:
			System.out.println("등급은 A입니다.");
			break;
			
		case 8: 
			System.out.println("등급은 B입니다.");
			break;
			
		case 7: 
			System.out.println("등급은 C입니다.");
			break;
			
		case 6: 
			System.out.println("등급은 D입니다.");
			break;
			
		default:
			System.out.println("노력하세요");
			break;
		}
	}

}

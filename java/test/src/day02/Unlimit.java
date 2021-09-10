package day02;

public class Unlimit {

	public static void main(String[] args) {
		int i = 0;
		
		while(true) {
			i++;
			if((i%2 == 0)&&(i%3 == 0)&&(i%4 == 0)) 
				break;
		}
		System.out.println("2, 3, 4의 배수는 "+i+"입니다.");
	}

}

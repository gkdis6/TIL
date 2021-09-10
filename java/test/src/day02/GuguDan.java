package day02;

public class GuguDan {

	public static void main(String[] args) {
		for(int i = 1; i <= 9; i+=3) {
			System.out.println(" " + i + "단\t\t " + (i+1)+"단\t\t "+ (i+2) + "단\t\t " );
			
			System.out.println("---------------------------------------------");
			
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + i*j + "\t");
                
                System.out.print((i+1) + " * " + j + " = " + (i+1)*j + "\t");
                  
                System.out.println((i+2) + " * " + j + " = " + (i+2)*j);
			}
			System.out.println();
		}
	}
}

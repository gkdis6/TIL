package day04_test;

import java.util.Scanner;

class Calc{
	private int n1, n2, comp;
	
	public void setN1(int n) {
		n1 = n;
	}
	
	public int getN1() {
		return n1;
	}
	
	public void setN2(int n) {
		n2 = n;
	}
	
	public int getN2() {
		return n2;
	}
	
	public void setComp(int n) {
		comp = n;
	}
	
	public int getComp() {
		return comp;
	}
	
	public void input(int n1, int n2, int comp) {
		this.n1 = n1;
		this.n2 = n2;
		this.comp = comp;
	}
	
	public int calc(int n1, int comp, int n2) {
		
		switch (comp) {
		case 1: return n1+n2; 
		case 2: return n1-n2;
		case 3: return n1*n2;
		case 4: 
			if(n2 != 0) 
				return n1/n2;
			else {
				System.out.println("0으로 나눌 수 없습니다.");
				return 0;
			}
		case 5: return n1%n2;
			
		default:
			System.out.println("잘못 입력되었습니다. 1~5 사이의 수를 입력해주세요.");
			return 0;
		}
	}
	
	public void print(Calc c) {
		System.out.println("계산 결과는 "+calc(n1, comp, n2)+"입니다.");
	}
	
	//input calc print
}

public class CalcTest {

	public static void main(String[] args) {
		Calc c = new Calc();
		Scanner in = new Scanner(System.in);
		
		System.out.println("=======게산기=======");
		System.out.println("숫자를 입력해주세요.");
		c.setN1(in.nextInt());
		
		
		System.out.println("(1) + \t (2) - \t (3) *");
		System.out.println("(4) / \t (5) %");
		c.setComp(in.nextInt());
		
		System.out.println("숫자를 입력해주세요.");
		c.setN2(in.nextInt());
		
		c.print(c);
	}

}

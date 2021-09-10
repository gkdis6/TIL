package day05_test;

import java.text.DecimalFormat;
import java.util.Scanner;

class Circle {
	private int r;
	DecimalFormat df = new DecimalFormat("###.##");

	public void setR(int n) {
		this.r = n;
	}

	public int getR() {
		return r;
	}

	public void printCircle() {
		System.out.println("====== 원의 넓이와 둘레 ======");
		System.out.println("원의 반지름 : " + r);
		System.out.println("원의 둘레 : " + df.format(round()));
		System.out.println("원의 넓이 : " + df.format(area()));
	}

	public double round() {
		return 2 * Math.PI * r;
	}

	public double area() {
		return Math.PI * r * r;
	}

	Circle(int n) {
		r = n;
	}

	Circle() {
	}

}

class Triangle {
	private int a;
	private int b;
	private int c;
	DecimalFormat df = new DecimalFormat("###.##");

	Triangle(int n1, int n2, int n3) {
		a = n1;
		b = n2;
		c = n3;
	}

	public Triangle() {
	}

	public void set(int n1, int n2, int n3) {
		a = n1;
		b = n2;
		c = n3;
	}

	public int get(int n) {
		if (n == 1)
			return a;
		if (n == 2)
			return b;
		if (n == 3)
			return c;
		return 0;
	}

	public void printTriangle() {
		System.out.println("====== 삼각형의 넓이와 둘레 ======");
		System.out.println("세 변의 길이 : " + get(1) + " " + get(2) + " " + get(3));
		System.out.println("삼각형의 둘레 : " + df.format(round()));
		System.out.println("삼각형의 넓이 : " + df.format(area()));
	}

	public double round() {
		return a + b + c;
	}

	public double area() {
		return Math.sqrt(round() / 2 * (round() - a) * (round() - b) * (round() - c));
	}

}

class Rect {
	private int a;
	private int b;
	DecimalFormat df = new DecimalFormat("###.##");

	Rect(int n1, int n2) {
		a = n1;
		b = n2;
	}

	public Rect() {
	}

	public void set(int n1, int n2) {
		a = n1;
		b = n2;
	}

	public int get(int n) {
		if (n == 1)
			return a;
		if (n == 2)
			return b;
		return 0;
	}

	public void printRect() {
		System.out.println("====== 직사각형의 넓이와 둘레 ======");
		System.out.println("두 변의 길이 : " + get(1) + ", " + get(2));
		System.out.println("직사각형의 둘레 : " + df.format(round()));
		System.out.println("직사각형의 넓이 : " + df.format(area()));
	}

	public double round() {
		return 2 * (a + b);
	}

	public double area() {
		return a * b;
	}

}

public class ShapesTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("어떤 도형이 궁금하신가요?");
		System.out.println("(1) 원 \t (2) 삼각형 \t (3) 직사각형");
		int n = in.nextInt();

		if (n == 1) {
			System.out.println("원의 반지름을 정해주세요");
			Circle c = new Circle(in.nextInt());
			c.printCircle();
		} else if (n == 2) {
			int a, b, c;
			do {
				System.out.println("한변의 길이가 너무 길면 삼각형이 만들어 질 수 없습니다.");
				System.out.println("첫번째 변의 길이");
				a = in.nextInt();
				System.out.println("두번째 변의 길이");
				b = in.nextInt();
				System.out.println("세번째 변의 길이");
				c = in.nextInt();
			}while (a + b <= c || a + c <= b || b + c <= a);
			Triangle t = new Triangle(a, b, c);
			t.printTriangle();
		} else if (n == 3) {
			System.out.println("직사각형의 변의 길이를 정해주세요");
			System.out.println("첫번째 변의 길이");
			int a = in.nextInt();
			System.out.println("두번째 변의 길이");
			int b = in.nextInt();
			Rect r = new Rect(a, b);
			r.printRect();
		}

	}

}

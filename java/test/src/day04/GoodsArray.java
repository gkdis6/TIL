package day04;

import java.util.Scanner;

public class GoodsArray {
	public static void main(String[] args) {
		Goods[] goodsArray;
		goodsArray = new Goods[3];

		for (int i = 0; i < goodsArray.length; i++) {
			Scanner s = new Scanner(System.in);
			String name = s.next(); // 상품 이름
			int price = s.nextInt(); // 상품 가격
			int n = s.nextInt(); // 상품 재고
			int sold = s.nextInt(); // 팔린 수량
			goodsArray[i] = new Goods(name, price, n, sold); // 객체 생성
		}

		for (int i = 0; i < goodsArray.length; i++) {
			System.out.print(goodsArray[i].getName() + " "); // 상품 이름 출력
			System.out.print(goodsArray[i].getPrice() + " "); // 상품 가격 출력
			System.out.print(goodsArray[i].getNumberOfStock() + " "); // 상품 재고 출력
			System.out.println(goodsArray[i].getSold()); // 팔린 수량 출력
		}
	}
}

class Goods {
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;

	Goods(String name, int price, int numberOfStock, int sold) { // 생성자
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}

	String getName() {
		return name;
	} // 상품 이름 반환

	int getPrice() {
		return price;
	} // 상품 가격 반환

	int getNumberOfStock() {
		return numberOfStock;
	} // 상품 재고 반환

	int getSold() {
		return sold;
	} // 팔린 수량 반환
}

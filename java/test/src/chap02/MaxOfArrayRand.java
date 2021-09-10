package chap02;

import java.util.Random;

public class MaxOfArrayRand {

	public static void main(String[] args) {
		Random random = new Random();
		
		System.out.println("키의 최댓값을 구합니다.");
		int num = random.nextInt(11); //0~n-1까지의 수가 랜덤으로 나옴 
		System.out.println("사람 수 : "+num);
		
		
		int[] height = new int[num];
		
		System.out.println("키 값은 아래와 같습니다.");
		for(int i = 0; i<num; i++) {
			height[i] = 100+random.nextInt(90);
			System.out.println("height["+i+"] : " + height[i]);
		}
		System.out.println("최댓값은 "+maxOf(height)+"입니다.");
	}

	public static int maxOf(int[] a) {
		int max = a[0];
		
		for(int i = 1; i<a.length; i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max;
	}
}

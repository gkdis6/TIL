package day02;

public class Compare { 
	   public static void main(String args[]) { 
	      int i = 5; 
	      int j = 10; 
	      int k = 15; 

	      System.out.println("5 == 10 : " + (i == j)); // false 
	      System.out.println("5 != 15 : " + (i != k)); // true 
	      System.out.println("10 < 15 : " + (j < k)); 
	      System.out.println("k>i     : " + (k > i)); 
	      System.out.println("i<=k    : " + (i <= k)); 
	      System.out.println("i>=j    : " + (i >= j)); 
	       
	      //연산 순서: () ---> 산술 연산자 --> 관계 연산자 
	      System.out.println("10 + 5 < 20 + 10 : " + (10 + 5 < 20 + 10)); 
	       
	   } 
	} 